package com.lp.article.service.impl;

import com.lp.article.dao.CommentDao;
import com.lp.article.pojo.Comment;
import com.lp.article.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/11/24 14:28
 * @Version 1.0
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    public void add(Comment comment){
        commentDao.save(comment);
    }

    @Override
    public List<Comment> findByArticleid(String articleid){
        return commentDao.findByArticleid(articleid);
    }

    public void delById(String id){
        commentDao.delete(id);
    }
}
