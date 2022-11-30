package com.lp.search.controller;

import com.lp.common.entity.PageResult;
import com.lp.common.entity.Result;
import com.lp.common.entity.StatusCode;
import com.lp.search.pojo.Article;
import com.lp.search.service.impl.ArticleSearchServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @Author lipeng
 * @Date 2022/11/24 15:49
 * @Version 1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/article")
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleSearchServiceImpl articleSearchService;

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Article article) {
        articleSearchService.add(article);
        log.debug("添加一条文章搜索索引[{}]", article);
        return new Result(true, StatusCode.OK, "操作成功");
    }

    @RequestMapping(value = "/search/{keywords}/{page}/{size}", method = RequestMethod.GET)
    public Result findByTitleLike(@PathVariable String keywords,
                                  @PathVariable int page, @PathVariable int size) {
        Page<Article> articlePage =
                articleSearchService.findByTitleLike(keywords, page, size);
        log.debug("标题[{}]查询到[{}]条数据=>[{}]", keywords, articlePage.getNumber(), articlePage);
        return new Result(true, StatusCode.OK, "查询成功",
                new PageResult<Article>(articlePage.getTotalElements(),
                        articlePage.getContent()));
    }
}
