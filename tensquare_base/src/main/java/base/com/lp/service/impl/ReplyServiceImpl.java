package base.com.lp.service.impl;

import base.com.lp.dao.ReplyDao;
import base.com.lp.pojo.Reply;
import base.com.lp.service.ReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/11/18 14:20
 * @Version 1.0
 */
@Slf4j
@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyDao replyDao;

    public List<Reply> findALll(){
        List<Reply> list = replyDao.findAll();
        log.debug("查找数据库中所有回答=>[{}]", list);
        return list;
    }
}
