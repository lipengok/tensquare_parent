package com.lp.search.service;

import com.lp.search.pojo.Article;
import org.springframework.data.domain.Page;

/**
 * @Author lipeng
 * @Date 2022/11/24 15:47
 * @Version 1.0
 */
public interface ArticleSearchService {

    Page<Article> findByTitleLike(String keywords, int page, int size);
}
