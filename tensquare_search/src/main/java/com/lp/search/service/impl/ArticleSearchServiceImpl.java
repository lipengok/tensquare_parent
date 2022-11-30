package com.lp.search.service.impl;

import com.lp.search.dao.ArticleSearchDao;
import com.lp.search.pojo.Article;
import com.lp.search.service.ArticleSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @Author lipeng
 * @Date 2022/11/24 15:48
 * @Version 1.0
 */
@Service
public class ArticleSearchServiceImpl implements ArticleSearchService {

    @Autowired
    private ArticleSearchDao articleSearchDao;

    /**
     * 增加文章索引
     *
     * @param article
     */
    public void add(Article article) {
        articleSearchDao.save(article);
    }

    @Override
    public Page<Article> findByTitleLike(String keywords, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return articleSearchDao.findByTitleOrContentLike(keywords, keywords, pageRequest);
    }
}
