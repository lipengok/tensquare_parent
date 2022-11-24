package com.lp.article.dao;

import com.lp.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/11/24 14:26
 * @Version 1.0
 */
public interface CommentDao extends MongoRepository<Comment, String> {

    /**
     * 根据文章ID查询评论列表
     * @param articleid
     * @return
     */
    List<Comment> findByArticleid(String articleid);
}
