package com.amur.home.course.service.impl;

import com.amur.home.common.Constants;
import com.amur.home.course.client.TinyIdClient;
import com.amur.home.course.dto.PageResult;
import com.amur.home.course.entity.*;
import com.amur.home.course.mapper.*;
import com.amur.home.course.service.CourseService;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.*;

@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseInfoMapper courseInfoMapper;

    @Resource
    private CourseListMapper courseListMapper;

    @Resource
    private CourseJoinMapper courseJoinMapper;

    @Resource
    private CourseCommentMapper courseCommentMapper;
    @Resource
    private CourseShareMapper courseShareMapper;

    @Resource
    private MinioClient minioClient;

    @Resource
    private TinyIdClient tinyIdClient;

    @Value("${minio.bucket-name}")
    private String bucketName;

    @Value("${minio.endpoint}")
    private String endpoint;

    /**
     * @param homeId      家庭id
     * @param name        课程名称
     * @param description 课程描述
     * @param startTime   开始时间
     * @param endTime     结束时间
     * @param coverUrl    封面图片
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Long> courseAdd(Long homeId, Long userId, String name, String description, Date startTime, Date endTime, String coverUrl) {
        CourseInfo courseInfo = new CourseInfo();
        ServiceResult<Long> res = tinyIdClient.getNextId(Constants.TableName.COURSE_INFO.getDesc());
        if (!res.isSuccess()) {
            return ServiceResult.fail("id生成失败");
        }
        courseInfo.setId(res.getData());
        courseInfo.setHomeId(homeId);
        courseInfo.setName(name);
        courseInfo.setDescription(description);
        courseInfo.setStartTime(startTime);
        courseInfo.setEndTime(endTime);
        courseInfo.setCoverUrl(coverUrl);
        Set<Long> teacherIds = Collections.singleton(userId);
        courseInfo.setTeacherIds(teacherIds);
        if (courseInfoMapper.insert(courseInfo) > 0) {
            return ServiceResult.success(courseInfo.getId());
        } else {
            return ServiceResult.fail("添加课程失败");
        }
    }

    /**
     * @param file 文件
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<String> courseAddCover(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        String fileExtension = Objects.requireNonNull(originalFileName).substring(originalFileName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String newFileName = uuid + fileExtension;

        try {
            InputStream inputStream = file.getInputStream();
            minioClient.putObject(PutObjectArgs.builder().bucket(bucketName).object(newFileName).stream(inputStream, inputStream.available(), -1).build());
        } catch (Exception e) {
            return ServiceResult.fail("获取文件信息失败");
        }
        String fileUrl = endpoint + "/" + bucketName + "/" + newFileName;
        return ServiceResult.success(fileUrl);
    }

    /**
     * @param courseId 课程id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> courseDel(Long courseId) {
        QueryWrapper<CourseComment> queryWrapperComment = new QueryWrapper<>();
        queryWrapperComment.eq("course_id", courseId);
        courseCommentMapper.delete(queryWrapperComment);
        QueryWrapper<CourseList> queryWrapperList = new QueryWrapper<>();
        queryWrapperList.eq("course_id", courseId);
        List<CourseList> courseListList = courseListMapper.selectList(queryWrapperList);
        for (CourseList courseList : courseListList) {
            Set<Long> courseIds = courseList.getCourseIds();
            if (courseIds == null) continue;
            courseIds.remove(courseId);
            courseList.setCourseIds(courseIds);
            courseListMapper.updateById(courseList);
        }
        QueryWrapper<CourseShare> queryWrapperShare = new QueryWrapper<>();
        queryWrapperShare.eq("course_id", courseId);
        courseShareMapper.delete(queryWrapperShare);
        QueryWrapper<CourseJoinRelation> queryWrapperJoin = new QueryWrapper<>();
        queryWrapperJoin.eq("course_id", courseId);
        courseJoinMapper.delete(queryWrapperJoin);
        if (courseInfoMapper.deleteById(courseId) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("删除失败");
        }
    }

    /**
     * @param homeId  家庭id
     * @param keyword 关键字
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<PageResult<CourseInfo>> courseSearch(Long homeId, String keyword, Integer pageNum, Integer pageSize) {
        QueryWrapper<CourseInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("home_id", homeId).like("name", keyword).or().like("description", keyword).orderByDesc("create_time");
        Page<CourseInfo> page = new Page<>(pageNum, pageSize);
        IPage<CourseInfo> coursePage = courseInfoMapper.selectPage(page, queryWrapper);
        if (coursePage.getTotal() > 0) {
            PageResult<CourseInfo> result = new PageResult<>(pageNum, pageSize, coursePage.getTotal(), coursePage.getPages(), coursePage.getRecords());
            return ServiceResult.success(result);
        } else {
            return ServiceResult.fail("没有搜索到相关课程");
        }
    }

    /**
     * @param courseInfo 课程信息
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> courseUpdate(CourseInfo courseInfo) {
        if (courseInfoMapper.updateById(courseInfo) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("更新失败");
        }
    }

    /**
     * @param courseId 课程id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<CourseInfo> courseInfo(Long courseId) {
        CourseInfo courseInfo = courseInfoMapper.selectById(courseId);
        if (courseInfo != null) {
            return ServiceResult.success(courseInfo);
        } else {
            return ServiceResult.fail("获取课程信息失败");
        }
    }

    /**
     * @param userId 用户id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<List<CourseInfo>> courseInfoByUserId(Long userId) {
        QueryWrapper<CourseInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId).orderByDesc("create_time");
        List<CourseInfo> courseInfoList = courseInfoMapper.selectList(queryWrapper);
        if (courseInfoList.size() > 0) {
            return ServiceResult.success(courseInfoList);
        } else {
            return ServiceResult.fail("没有搜索到相关课程");
        }
    }

    /**
     * @param homeId 家庭id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<List<CourseInfo>> courseInfoByHomeId(Long homeId) {
        QueryWrapper<CourseInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("home_id", homeId).orderByDesc("create_time");
        List<CourseInfo> courseInfoList = courseInfoMapper.selectList(queryWrapper);
        if (courseInfoList.size() > 0) {
            return ServiceResult.success(courseInfoList);
        } else {
            return ServiceResult.fail("没有搜索到相关课程");
        }
    }

    /**
     * @param courseId 课程id
     * @param rank     评分
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> rank(Long courseId, Double rank) {
        CourseInfo courseInfo = courseInfoMapper.selectById(courseId);
        if (courseInfo == null) {
            return ServiceResult.fail("课程不存在");
        }
        Long scoreCount = courseInfo.getScoreCount();
        Double score = courseInfo.getScore();
        Double newScore = (score * scoreCount + rank) / (scoreCount + 1);
        courseInfo.setScore(newScore);
        courseInfo.setScoreCount(scoreCount + 1);
        if (courseInfoMapper.updateById(courseInfo) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("评分失败");
        }
    }

    /**
     * @param courseId 课程id
     * @param userId   用户id
     * @param comment  评论内容
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Long> commentAdd(Long courseId, Long userId, String comment) {
        CourseInfo courseInfo = courseInfoMapper.selectById(courseId);
        if (courseInfo == null) {
            return ServiceResult.fail("课程不存在");
        }
        CourseComment courseComment = new CourseComment();
        ServiceResult<Long> res = tinyIdClient.getNextId(Constants.TableName.COURSE_COMMENT.getDesc());
        if (!res.isSuccess()) {
            return ServiceResult.fail("id生成失败");
        }
        courseComment.setId(res.getData());
        courseComment.setCourseId(courseId);
        courseComment.setUserId(userId);
        courseComment.setContent(comment);
        courseInfo.setCommentCount(courseInfo.getCommentCount() + 1);
        if (courseCommentMapper.insert(courseComment) > 0 && courseInfoMapper.updateById(courseInfo) > 0) {
            return ServiceResult.success(courseComment.getId());
        } else {
            return ServiceResult.fail("评论失败");
        }
    }

    /**
     * @param courseId 课程id
     * @param userId   用户id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> commentDel(Long courseId, Long userId) {
        CourseInfo courseInfo = courseInfoMapper.selectById(courseId);
        if (courseInfo == null) {
            return ServiceResult.fail("课程不存在");
        }
        QueryWrapper<CourseComment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", courseId).eq("user_id", userId);
        courseInfo.setCommentCount(courseInfo.getCommentCount() - 1);
        if (courseCommentMapper.delete(queryWrapper) > 0 && courseInfoMapper.updateById(courseInfo) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("记录不存在或删除失败!");
        }
    }

    /**
     * @param courseId 课程id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> commentInfoList(Long courseId) {
        QueryWrapper<CourseComment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", courseId).orderByDesc("create_time");
        List<CourseComment> courseComments = courseCommentMapper.selectList(queryWrapper);
        if (courseComments.size() > 0) {
            return ServiceResult.success(courseComments);
        } else {
            return ServiceResult.fail("没有搜索到相关评论");
        }
    }

    /**
     * @param courseId 课程id
     * @param keyword  关键字
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> commentInfoList(Long courseId, String keyword) {
        QueryWrapper<CourseComment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", courseId).like("content", keyword).orderByDesc("create_time");
        List<CourseComment> courseComments = courseCommentMapper.selectList(queryWrapper);
        if (courseComments.size() > 0) {
            return ServiceResult.success(courseComments);
        } else {
            return ServiceResult.fail("没有搜索到相关评论");
        }
    }

    /**
     * @param userId 用户id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> commentInfoByUserId(Long userId) {
        QueryWrapper<CourseComment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId).orderByDesc("create_time");
        List<CourseComment> courseComments = courseCommentMapper.selectList(queryWrapper);
        if (courseComments.size() > 0) {
            return ServiceResult.success(courseComments);
        } else {
            return ServiceResult.fail("没有搜索到相关评论");
        }
    }

    /**
     * @param courseId   课程id
     * @param inviterId  邀请人id
     * @param as         邀请身份
     * @param expireTime 过期时间
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> share(Long courseId, Long inviterId, Constants.InviteAs as, Date expireTime) {
        CourseShare courseShare = new CourseShare();
        courseShare.setCourseId(courseId);
        courseShare.setInviterId(inviterId);
        courseShare.setInviteAs(as);
        courseShare.setExpireTime(expireTime);
        String uuid = UUID.randomUUID().toString().replace("-", "");
        courseShare.setToken(uuid);
        if (courseShareMapper.insert(courseShare) > 0) {
            return ServiceResult.success(courseShare.getToken());
        } else {
            return ServiceResult.fail("分享失败");
        }
    }

    /**
     * @param shareToken 分享token
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<CourseShare> shareInfo(String shareToken) {
        CourseShare courseShare = courseShareMapper.selectById(shareToken);
        if (courseShare != null) {
            return ServiceResult.success(courseShare);
        } else {
            return ServiceResult.fail("没有搜索到相关分享");
        }
    }

    /**
     * @param shareToken 分享token
     * @param userId     用户id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<CourseShare> joinByToken(String shareToken, Long userId) {
        CourseShare courseShare = courseShareMapper.selectById(shareToken);
        if (courseShare == null) {
            return ServiceResult.fail("分享不存在");
        }
        if (courseShare.getExpireTime().before(new Date())) {
            return ServiceResult.fail("分享已过期");
        }
        CourseInfo courseInfo = courseInfoMapper.selectById(courseShare.getCourseId());
        if (courseInfo == null) {
            return ServiceResult.fail("课程不存在");
        }
        if (courseShare.getInviteAs().equals(Constants.InviteAs.AS_STUDENT)) {
            CourseJoinRelation courseJoinRelation = new CourseJoinRelation();
            ServiceResult<Long> res = tinyIdClient.getNextId(Constants.TableName.COURSE_JOIN.getDesc());
            if (!res.isSuccess()) {
                return ServiceResult.fail("id生成失败");
            }
            courseJoinRelation.setId(res.getData());
            courseJoinRelation.setCourseId(courseShare.getCourseId());
            courseJoinRelation.setUserId(userId);
            Set<Long> studentIds = courseInfo.getStudentIds();
            if (studentIds.contains(userId)) {
                return ServiceResult.fail("已加入");
            }
            studentIds.add(userId);
            courseInfo.setStudentIds(studentIds);
            if (courseInfoMapper.updateById(courseInfo) > 0 && courseJoinMapper.insert(courseJoinRelation) > 0) {
                return ServiceResult.success(courseShare);
            } else {
                return ServiceResult.fail("加入失败");
            }
        } else if (courseShare.getInviteAs().equals(Constants.InviteAs.AS_TEACHER)) {
            Set<Long> teacherIds = courseInfo.getTeacherIds();
            if (teacherIds.contains(userId)) {
                return ServiceResult.fail("已加入");
            }
            teacherIds.add(userId);
            courseInfo.setTeacherIds(teacherIds);
            if (courseInfoMapper.updateById(courseInfo) > 0) {
                return ServiceResult.success(courseShare);
            } else {
                return ServiceResult.fail("加入失败");
            }
        } else {
            return ServiceResult.fail("分享身份错误");
        }
    }

    /**
     * @param userId 用户id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> shareInfoByUserId(Long userId) {
        QueryWrapper<CourseShare> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("inviter_id", userId).orderByDesc("create_time");
        List<CourseShare> courseShares = courseShareMapper.selectList(queryWrapper);
        if (courseShares.size() > 0) {
            return ServiceResult.success(courseShares);
        } else {
            return ServiceResult.fail("没有搜索到相关分享");
        }
    }

    /**
     * @param courseId 课程id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> shareInfoById(Long courseId) {
        QueryWrapper<CourseShare> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", courseId).orderByDesc("create_time");
        List<CourseShare> courseShares = courseShareMapper.selectList(queryWrapper);
        if (courseShares.size() > 0) {
            return ServiceResult.success(courseShares);
        } else {
            return ServiceResult.fail("没有搜索到相关分享");
        }
    }

    /**
     * @param shareToken 分享token
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> shareCancel(String shareToken) {
        CourseShare courseShare = courseShareMapper.selectById(shareToken);
        if (courseShare == null) {
            return ServiceResult.fail("分享不存在");
        }
        if (courseShareMapper.deleteById(shareToken) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("取消分享失败");
        }
    }

    /**
     * @param courseId 课程id
     * @param userId   用户id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> addStudent(Long courseId, Long userId) {
        CourseJoinRelation courseJoinRelation = new CourseJoinRelation();
        ServiceResult<Long> res = tinyIdClient.getNextId(Constants.TableName.COURSE_JOIN.getDesc());
        if (!res.isSuccess()) {
            return ServiceResult.fail("id生成失败");
        }
        courseJoinRelation.setId(res.getData());
        courseJoinRelation.setCourseId(courseId);
        courseJoinRelation.setUserId(userId);
        if (courseJoinMapper.insert(courseJoinRelation) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("添加失败");
        }
    }

    /**
     * @param courseId 课程id
     * @param userId   用户id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> delStudent(Long courseId, Long userId) {
        QueryWrapper<CourseJoinRelation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", courseId).eq("user_id", userId);
        if (courseJoinMapper.delete(queryWrapper) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("记录不存在或删除失败!");
        }
    }

    /**
     * @param courseId 课程id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> listStudent(Long courseId) {
        QueryWrapper<CourseJoinRelation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", courseId);
        List<CourseJoinRelation> courseJoinRelations = courseJoinMapper.selectList(queryWrapper);
        if (courseJoinRelations.size() > 0) {
            return ServiceResult.success(courseJoinRelations);
        } else {
            return ServiceResult.fail("没有搜索到相关记录");
        }
    }

    /**
     * @param courseId 课程id
     * @param userId   用户id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> addTeacher(Long courseId, Long userId) {
        CourseInfo courseInfo = courseInfoMapper.selectById(courseId);
        if (courseInfo == null) {
            return ServiceResult.fail("课程不存在");
        }
        Set<Long> teacherIdSet = courseInfo.getTeacherIds();
        if (teacherIdSet == null) {
            teacherIdSet = new HashSet<>();
        }
        if (teacherIdSet.contains(userId)) {
            return ServiceResult.fail("该用户已经是教师");
        }
        teacherIdSet.add(userId);
        courseInfo.setTeacherIds(teacherIdSet);
        if (courseInfoMapper.updateById(courseInfo) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("添加失败");
        }
    }

    /**
     * @param courseId 课程id
     * @param userId   用户id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> delTeacher(Long courseId, Long userId) {
        CourseInfo courseInfo = courseInfoMapper.selectById(courseId);
        if (courseInfo == null) {
            return ServiceResult.fail("课程不存在");
        }
        Set<Long> teacherIdSet = courseInfo.getTeacherIds();
        if (teacherIdSet == null) {
            teacherIdSet = new HashSet<>();
        }
        if (!teacherIdSet.contains(userId)) {
            return ServiceResult.fail("该用户不是教师");
        }
        teacherIdSet.remove(userId);
        courseInfo.setTeacherIds(teacherIdSet);
        if (courseInfoMapper.updateById(courseInfo) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("删除失败");
        }
    }

    /**
     * @param courseId 课程id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> listTeacher(Long courseId) {
        CourseInfo courseInfo = courseInfoMapper.selectById(courseId);
        if (courseInfo == null) {
            return ServiceResult.fail("课程不存在");
        }
        Set<Long> teacherIdSet = courseInfo.getTeacherIds();
        if (teacherIdSet == null) {
            teacherIdSet = new HashSet<>();
        }
        if (teacherIdSet.size() > 0) {
            return ServiceResult.success(teacherIdSet);
        } else {
            return ServiceResult.fail("没有搜索到相关记录");
        }
    }

    /**
     * @param homeId       家庭id
     * @param title        标题
     * @param description  描述
     * @param open         是否公开
     * @param courseIdList 课程id列表
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> createList(Long homeId, String title, String description, boolean open, List<Long> courseIdList) {
        CourseList courseList = new CourseList();
        ServiceResult<Long> res = tinyIdClient.getNextId(Constants.TableName.COURSE_LIST.getDesc());
        if (!res.isSuccess()) {
            return ServiceResult.fail("id生成失败");
        }
        courseList.setId(res.getData());
        courseList.setHomeId(homeId);
        courseList.setTitle(title);
        courseList.setDescription(description);
        courseList.setOpen(open);
        courseList.setCourseIds(new HashSet<>(courseIdList));
        if (courseListMapper.insert(courseList) > 0) {
            return ServiceResult.success(courseList.getId());
        } else {
            return ServiceResult.fail("创建失败");
        }
    }

    /**
     * @param courseId 课程id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> courseListInfo(Long courseId) {
        CourseList courseList = courseListMapper.selectById(courseId);
        if (courseList != null) {
            return ServiceResult.success(courseList);
        } else {
            return ServiceResult.fail("没有搜索到相关记录");
        }
    }

    /**
     * @param keyword 关键字
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> courseListSearch(String keyword) {
        QueryWrapper<CourseList> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", keyword).or().like("description", keyword);
        List<CourseList> courseLists = courseListMapper.selectList(queryWrapper);
        if (courseLists.size() > 0) {
            return ServiceResult.success(courseLists);
        } else {
            return ServiceResult.fail("没有搜索到相关记录");
        }
    }

    /**
     * @param homeId 家庭id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> courseListInfoByHomeId(Long homeId) {
        QueryWrapper<CourseList> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("home_id", homeId);
        List<CourseList> courseLists = courseListMapper.selectList(queryWrapper);
        if (courseLists.size() > 0) {
            return ServiceResult.success(courseLists);
        } else {
            return ServiceResult.fail("没有搜索到相关记录");
        }
    }

    /**
     * @param listId 课程列表id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> deleteList(Long listId) {
        if (courseListMapper.deleteById(listId) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("删除失败");
        }
    }

    /**
     * @param listId   课程列表id
     * @param courseId 课程id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> listAdd(Long listId, Long courseId) {
        CourseList courseList = courseListMapper.selectById(listId);
        if (courseList == null) {
            return ServiceResult.fail("课程列表不存在");
        }
        Set<Long> courseIdSet = courseList.getCourseIds();
        if (courseIdSet == null) {
            courseIdSet = new HashSet<>();
        }
        if (courseIdSet.contains(courseId)) {
            return ServiceResult.fail("该课程已经在列表中");
        }
        courseIdSet.add(courseId);
        courseList.setCourseIds(courseIdSet);
        if (courseListMapper.updateById(courseList) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("添加失败");
        }
    }

    /**
     * @param listId   课程列表id
     * @param courseId 课程id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> listRemove(Long listId, Long courseId) {
        CourseList courseList = courseListMapper.selectById(listId);
        if (courseList == null) {
            return ServiceResult.fail("课程列表不存在");
        }
        Set<Long> courseIdSet = courseList.getCourseIds();
        if (courseIdSet == null) {
            courseIdSet = new HashSet<>();
        }
        if (!courseIdSet.contains(courseId)) {
            return ServiceResult.fail("该课程不在列表中");
        }
        courseIdSet.remove(courseId);
        courseList.setCourseIds(courseIdSet);
        if (courseListMapper.updateById(courseList) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("删除失败");
        }
    }

    /**
     * @param courseList 课程列表
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> listUpdate(CourseList courseList) {
        if (courseListMapper.updateById(courseList) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("更新失败");
        }
    }

    /**
     * @param courseId 课程id
     * @param userId   用户id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> addLikeCourse(Long courseId, Long userId) {
        CourseInfo courseInfo = courseInfoMapper.selectById(courseId);
        if (courseInfo == null) {
            return ServiceResult.fail("课程不存在");
        }
        courseInfo.setFavCount(courseInfo.getFavCount() + 1);
        if (courseInfoMapper.updateById(courseInfo) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("点赞保存失败");
        }
    }

    /**
     * @param courseId 课程id
     * @param userId   用户id
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<?> delLikeCourse(Long courseId, Long userId) {
        CourseInfo courseInfo = courseInfoMapper.selectById(courseId);
        if (courseInfo == null) {
            return ServiceResult.fail("课程不存在");
        }
        courseInfo.setFavCount(courseInfo.getFavCount() - 1);
        if (courseInfoMapper.updateById(courseInfo) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("点赞保存成功");
        }
    }
}
