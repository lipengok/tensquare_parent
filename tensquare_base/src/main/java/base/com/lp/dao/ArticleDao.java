package base.com.lp.dao;

import base.com.lp.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author lipeng
 * @Date 2022/11/18 15:12
 * @Version 1.0
 */
public interface ArticleDao extends JpaRepository<Article, String>, JpaSpecificationExecutor<Article> {

    /**
     * 审核文章
     * @param id
     */
    @Modifying
    @Query("update Article set state='1' where id=?1")
    void examine(String id);

    /**
     * 点赞
     * @param id
     * @return
     */
    @Modifying
    @Query("update Article set thumbup=thumbup+1 where id=?1")
    int updateThumbup(String id);
}
