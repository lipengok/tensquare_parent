package com.lp.base.redis;

import com.lp.base.dao.ArticleDao;
import com.lp.base.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Article的redis操作类
 * @Author lipeng
 * @Date 2022/11/18 16:20
 * @Version 1.0
 */
@Component
public class ArticleRedis {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ArticleDao articleDao;

    /**
     * 根据ID查询实体
     * @param id
     * @return
     */
    public Article findById(String id) {
        //从缓存中提取
        Article article = (Article) redisTemplate.opsForValue().get("article_" + id);
        // 如果缓存没有则到数据库查询并放入缓存
        if (article == null) {
            article = articleDao.findOne(id);
            redisTemplate.opsForValue().set("article_" + id, article);
        }
        return article;
    }

    /**
     * 修改
     * @param article
     */
    public void update(Article article) {
        redisTemplate.delete( "article_" + article.getId() );//删除缓存
        articleDao.save(article);
    }

    /**
     * 删除
     * @param id
     */
    public void deleteById(String id) {
        redisTemplate.delete( "article_" + id );//删除缓存
        articleDao.delete(id);
    }
}
