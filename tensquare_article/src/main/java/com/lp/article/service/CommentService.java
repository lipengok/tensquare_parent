package com.lp.article.service;

import com.lp.article.pojo.Comment;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/11/24 14:28
 * @Version 1.0
 */
public interface CommentService {

    List<Comment> findByArticleid(String articleid);
}
