package base.com.lp.service.impl;

import base.com.lp.dao.RecruitDao;
import base.com.lp.pojo.Recruit;
import base.com.lp.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/11/17 10:43
 * @Version 1.0
 */
@Service
public class RecruitServiceImpl implements RecruitService {

    @Autowired
    private RecruitDao recruitDao;

    public List<Recruit> findAll() {
        List<Recruit> list = recruitDao.findAll();
        return list;
    }

    /**
     * 根据状态查询
     *
     * @param state
     * @return
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state) {
        return recruitDao.findTop4ByStateOrderByCreatetimeDesc(state);
    }
}
