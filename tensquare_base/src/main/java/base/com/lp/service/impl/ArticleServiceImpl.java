package base.com.lp.service.impl;

import base.com.lp.dao.ArticleDao;
import base.com.lp.service.ArticleService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lipeng
 * @Date 2022/11/18 15:14
 * @Version 1.0
 */
@Log4j
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    public void examine(String id){
        articleDao.examine(id);
    }

    public void updateThumbup(String id){
        articleDao.updateThumbup(id);
    }
}
