package com.amur.home.msg.service;

import com.amur.home.dto.PageResult;
import com.amur.home.msg.entity.Issue;
import com.amur.home.msg.entity.IssueReply;
import com.amur.home.util.ServiceResult;

import java.util.Date;
import java.util.Set;

public interface IssueService {
    public ServiceResult<Long> createIssue(Long userId, Long homeId, String title, String content);

    ServiceResult<PageResult<Issue>> getFavIssueList(Long userId, Integer page, Integer size);

    ServiceResult<Boolean> delFavIssue(Long issueId, Long userId);

    ServiceResult<Boolean> FavIssue(Long issueId, Long userId);

    ServiceResult<Boolean> updateIssueStatus(Long issueId, Long status);

    ServiceResult<Boolean> updateIssueReply(Long replyId, String content);

    ServiceResult<Boolean> updateIssue(Long issueId, String title, String content);

    ServiceResult<PageResult<Issue>> searchIssue(Long userId, String keyword, Integer page, Integer size);

    ServiceResult<Boolean> deleteIssueReply(Long replyId);

    ServiceResult<Boolean> deleteIssue(Long issueId);

    ServiceResult<Long> replyIssue(Long issueId, Long userId, String content);

    ServiceResult<PageResult<IssueReply>> getIssueReplyList(Long issueId, Integer page, Integer size);

    ServiceResult<Issue> getIssueDetail(Long issueId);

    ServiceResult<PageResult<Issue>> getIssueList(Long userId, Integer page, Integer size);
}
