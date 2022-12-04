package com.amur.home.msg.controller;

import com.amur.home.dto.PageResult;
import com.amur.home.msg.entity.Issue;
import com.amur.home.msg.entity.IssueReply;
import com.amur.home.msg.service.IssueService;
import com.amur.home.util.ResponseWrapper;
import com.amur.home.util.ServiceResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Set;

@Tag(name = "交流提问服务")
@Controller
@RequestMapping("/issue")
public class IssueController {
    @Resource
    private IssueService issueService;

    @Operation(summary = "创建问题")
    @PostMapping("/create")
    @Parameters({@Parameter(name = "userId", description = "用户id"), @Parameter(name = "homeId", description = "家庭id"), @Parameter(name = "title", description = "标题"), @Parameter(name = "content", description = "内容")})
    public ResponseWrapper<Long> createIssue(Long userId, Long homeId, String title, String content) {
        ServiceResult<Long> res = issueService.createIssue(userId, homeId, title, content);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "获取问题列表")
    @PostMapping("/list/user")
    @Parameters({@Parameter(name = "userId", description = "用户id"), @Parameter(name = "page", description = "页码"), @Parameter(name = "size", description = "每页数量")})
    public ResponseWrapper<PageResult<Issue>> getIssueList(Long userId, Integer page, Integer size) {
        ServiceResult<PageResult<Issue>> res = issueService.getIssueList(userId, page, size);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "获取问题详情")
    @PostMapping("/detail")
    @Parameters({@Parameter(name = "issueId", description = "问题id")})
    public ResponseWrapper<Issue> getIssueDetail(Long issueId) {
        ServiceResult<Issue> res = issueService.getIssueDetail(issueId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "获取问题回复列表")
    @PostMapping("/reply/list")
    @Parameters({@Parameter(name = "issueId", description = "问题id"), @Parameter(name = "page", description = "页码"), @Parameter(name = "size", description = "每页数量")})
    public ResponseWrapper<PageResult<IssueReply>> getIssueReplyList(Long issueId, Integer page, Integer size) {
        ServiceResult<PageResult<IssueReply>> res = issueService.getIssueReplyList(issueId, page, size);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "回复问题")
    @PostMapping("/reply")
    @Parameters({@Parameter(name = "issueId", description = "问题id"), @Parameter(name = "userId", description = "用户id"), @Parameter(name = "content", description = "内容")})
    public ResponseWrapper<Long> replyIssue(Long issueId, Long userId, String content) {
        ServiceResult<Long> res = issueService.replyIssue(issueId, userId, content);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "删除问题")
    @PostMapping("/delete")
    @Parameters({@Parameter(name = "issueId", description = "问题id")})
    public ResponseWrapper<Boolean> deleteIssue(Long issueId) {
        ServiceResult<Boolean> res = issueService.deleteIssue(issueId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "删除问题回复")
    @PostMapping("/reply/delete")
    @Parameters({@Parameter(name = "replyId", description = "回复id")})
    public ResponseWrapper<Boolean> deleteIssueReply(Long replyId) {
        ServiceResult<Boolean> res = issueService.deleteIssueReply(replyId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "搜索问题")
    @PostMapping("/search")
    @Parameters({@Parameter(name = "userId", description = "用户id"), @Parameter(name = "keyword", description = "关键字"), @Parameter(name = "page", description = "页码"), @Parameter(name = "size", description = "每页数量")})
    public ResponseWrapper<PageResult<Issue>> searchIssue(Long userId, String keyword, Integer page, Integer size) {
        ServiceResult<PageResult<Issue>> res = issueService.searchIssue(userId, keyword, page, size);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "修改问题")
    @PostMapping("/update")
    @Parameters({@Parameter(name = "issueId", description = "问题id"), @Parameter(name = "title", description = "标题"), @Parameter(name = "content", description = "内容")})
    public ResponseWrapper<Boolean> updateIssue(Long issueId, String title, String content) {
        ServiceResult<Boolean> res = issueService.updateIssue(issueId, title, content);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "修改问题回复")
    @PostMapping("/reply/update")
    @Parameters({@Parameter(name = "replyId", description = "回复id"), @Parameter(name = "content", description = "内容")})
    public ResponseWrapper<Boolean> updateIssueReply(Long replyId, String content) {
        ServiceResult<Boolean> res = issueService.updateIssueReply(replyId, content);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }

    }

    @Operation(summary = "修改问题状态")
    @PostMapping("/update/status")
    @Parameters({@Parameter(name = "issueId", description = "问题id"), @Parameter(name = "status", description = "状态")})
    public ResponseWrapper<Boolean> updateIssueStatus(Long issueId, Long status) {
        ServiceResult<Boolean> res = issueService.updateIssueStatus(issueId, status);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "收藏问题")
    @PostMapping("/fav/add")
    @Parameters({@Parameter(name = "issueId", description = "问题id"), @Parameter(name = "userId", description = "用户id")})
    public ResponseWrapper<Boolean> FavIssue(Long issueId, Long userId) {
        ServiceResult<Boolean> res = issueService.FavIssue(issueId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "取消收藏问题")
    @PostMapping("/fav/delete")
    @Parameters({@Parameter(name = "issueId", description = "问题id"), @Parameter(name = "userId", description = "用户id")})
    public ResponseWrapper<Boolean> cancelFavIssue(Long issueId, Long userId) {
        ServiceResult<Boolean> res = issueService.delFavIssue(issueId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "获取收藏问题列表")
    @PostMapping("/fav/list")
    @Parameters({@Parameter(name = "userId", description = "用户id"), @Parameter(name = "page", description = "页码"), @Parameter(name = "size", description = "每页数量")})
    public ResponseWrapper<PageResult<Issue>> getFavIssueList(Long userId, Integer page, Integer size) {
        ServiceResult<PageResult<Issue>> res = issueService.getFavIssueList(userId, page, size);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }


}
