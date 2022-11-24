package com.lp.search.dao;

import com.lp.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author lipeng
 * @Date 2022/11/24 15:43
 * @Version 1.0
 */
public interface ArticleSearchDao extends ElasticsearchRepository<Article,String> {

    /**
     * 检索
     * @param
     * @return
     */
    Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);
}
