package com.amur.home.msg.service.impl;

import com.amur.home.dto.PageResult;
import com.amur.home.msg.client.TinyIdGrpcClient;
import com.amur.home.msg.client.UserGrpcClient;
import com.amur.home.msg.entity.Issue;
import com.amur.home.msg.entity.IssueReply;
import com.amur.home.msg.mapper.IssueMapper;
import com.amur.home.msg.mapper.IssueReplyMapper;
import com.amur.home.msg.service.IssueService;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {
    @Resource
    private IssueMapper issueMapper;

    @Resource
    private IssueReplyMapper issueReplyMapper;

    @Resource
    private TinyIdGrpcClient tinyIdGrpcClient;

    @Resource
    private UserGrpcClient userGrpcClient;

    @Override
    public ServiceResult<Long> createIssue(Long userId, Long homeId, String title, String content) {
        Long id = tinyIdGrpcClient.getNextId("issue").getData();
        Issue issue = new Issue(id, userId, homeId, title, content);
        if (issueMapper.insert(issue) > 0) {
            return ServiceResult.success(id);
        } else {
            return ServiceResult.ex("创建失败");
        }
    }

    /**
     * @param userId
     * @param page
     * @param size
     * @return
     */
    @Override
    public ServiceResult<PageResult<Issue>> getFavIssueList(Long userId, Integer page, Integer size) {
        List<Long> issueIdList = userGrpcClient.getFavIssue(userId).getData();
        if (issueIdList == null || issueIdList.isEmpty()) {
            return ServiceResult.success(PageResult.empty());
        }
        QueryWrapper<Issue> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", issueIdList);
        Page<Issue> issuePage = issueMapper.selectPage(new Page<>(page, size), queryWrapper);
        return ServiceResult.success(new PageResult<>(page, size, issuePage.getTotal(), issuePage.getPages(), issuePage.getRecords()));
    }

    /**
     * @param issueId
     * @param userId
     * @return
     */
    @Override
    public ServiceResult<Boolean> delFavIssue(Long issueId, Long userId) {
        return userGrpcClient.delFavIssue(userId, issueId);
    }

    /**
     * @param issueId
     * @param userId
     * @return
     */
    @Override
    public ServiceResult<Boolean> FavIssue(Long issueId, Long userId) {
        return userGrpcClient.addFavIssue(userId, issueId);
    }

    /**
     * @param issueId
     * @param status
     * @return
     */
    @Override
    public ServiceResult<Boolean> updateIssueStatus(Long issueId, Long status) {
        Issue issue = issueMapper.selectById(issueId);
        if (issue == null) {
            return ServiceResult.ex("不存在的问题");
        }
        issue.setStatus(status);
        if (issueMapper.updateById(issue) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("更新失败");
        }
    }

    @Override
    public ServiceResult<Boolean> updateIssueReply(Long replyId, String content) {
        IssueReply issueReply = issueReplyMapper.selectById(replyId);
        if (issueReply == null) {
            return ServiceResult.ex("不存在的回复");
        }
        issueReply.setContent(content);
        if (issueReplyMapper.updateById(issueReply) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("更新失败");
        }
    }

    @Override
    public ServiceResult<Boolean> updateIssue(Long issueId, String title, String content) {
        Issue issue = issueMapper.selectById(issueId);
        if (issue == null) {
            return ServiceResult.ex("不存在的问题");
        }
        issue.setTitle(title);
        issue.setContent(content);
        return ServiceResult.success(issueMapper.updateById(issue) > 0);
    }

    /**
     * @param userId
     * @param keyword
     * @param page
     * @param size
     * @return
     */
    @Override
    public ServiceResult<PageResult<Issue>> searchIssue(Long userId, String keyword, Integer page, Integer size) {
        QueryWrapper<Issue> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", keyword).or().like("content", keyword);
        Page<Issue> issuePage = issueMapper.selectPage(new Page<>(page, size), queryWrapper);
        return ServiceResult.success(new PageResult<>(page, size, issuePage.getTotal(), issuePage.getPages(), issuePage.getRecords()));
    }

    /**
     * @param replyId
     * @return
     */
    @Override
    public ServiceResult<Boolean> deleteIssueReply(Long replyId) {
        if (issueReplyMapper.deleteById(replyId) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("删除失败");
        }
    }

    /**
     * @param issueId
     * @return
     */
    @Override
    public ServiceResult<Boolean> deleteIssue(Long issueId) {
        if (issueMapper.deleteById(issueId) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("删除失败");
        }
    }

    @Override
    public ServiceResult<Long> replyIssue(Long issueId, Long userId, String content) {
        Long id = tinyIdGrpcClient.getNextId("issue_reply").getData();
        IssueReply issueReply = new IssueReply(id, issueId, userId, content);
        if (issueReplyMapper.insert(issueReply) > 0) {
            return ServiceResult.success(id);
        } else {
            return ServiceResult.ex("回复失败");
        }
    }

    /**
     * @param issueId
     * @param page
     * @param size
     * @return
     */
    @Override
    public ServiceResult<PageResult<IssueReply>> getIssueReplyList(Long issueId, Integer page, Integer size) {
        QueryWrapper<IssueReply> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("issue_id", issueId).orderBy(true, true, "create_time");
        Page<IssueReply> issueReplyPage = issueReplyMapper.selectPage(new Page<>(page, size), queryWrapper);
        return ServiceResult.success(new PageResult<>(page, size, issueReplyPage.getTotal(), issueReplyPage.getPages(), issueReplyPage.getRecords()));
    }

    /**
     * @param issueId
     * @return
     */
    @Override
    public ServiceResult<Issue> getIssueDetail(Long issueId) {
        Issue issue = issueMapper.selectById(issueId);
        if (issue == null) {
            return ServiceResult.ex("不存在的问题");
        }
        return ServiceResult.success(issue);
    }

    /**
     * @param userId
     * @param page
     * @param size
     * @return
     */
    @Override
    public ServiceResult<PageResult<Issue>> getIssueList(Long userId, Integer page, Integer size) {
        QueryWrapper<Issue> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId).orderBy(true, true, "create_time");
        Page<Issue> issuePage = issueMapper.selectPage(new Page<>(page, size), queryWrapper);
        return ServiceResult.success(new PageResult<>(page, size, issuePage.getTotal(), issuePage.getPages(), issuePage.getRecords()));
    }
}
