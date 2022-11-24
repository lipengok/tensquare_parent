package com.lp.article.controller;

import com.lp.article.pojo.Comment;
import com.lp.article.service.impl.CommentServiceImpl;
import com.lp.common.entity.Result;
import com.lp.common.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author lipeng
 * @Date 2022/11/24 14:33
 * @Version 1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @RequestMapping(method= RequestMethod.POST)
    public Result save(@RequestBody Comment comment){
        commentService.add(comment);
        return new Result(true, StatusCode.OK, "提交成功 ");
    }

    @RequestMapping(method= RequestMethod.DELETE, value = "/{id}")
    public Result save(@PathVariable String id){
        commentService.delById(id);
        return new Result(true, StatusCode.OK, "删除成功 ");
    }

    @RequestMapping(value="/article/{articleid}",method= RequestMethod.GET)
    public Result findByArticleid(@PathVariable String articleid){
        return new Result(true, StatusCode.OK, "查询成功", commentService.findByArticleid(articleid));
    }
}
