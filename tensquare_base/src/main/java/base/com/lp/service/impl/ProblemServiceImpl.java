package base.com.lp.service.impl;

import base.com.lp.dao.ProblemDao;
import base.com.lp.pojo.Problem;
import base.com.lp.service.ProblemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/11/18 10:10
 * @Version 1.0
 */
@Slf4j
@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemDao problemDao;

    public List<Problem> findAll(){
        return problemDao.findAll();
    }

    public Page<Problem> findNewListByLabelId(String labelId, int page, int size){
        Page<Problem> list = problemDao.findNewListByLabelId(labelId, new PageRequest(page, size));
        log.debug("标签id=>[{}]，问题=>[{}]", labelId, list);
        return list;
    }

    public Page<Problem> findHotListByLabelId(String labelId, int page, int size){
        Page<Problem> list = problemDao.findHotListByLabelId(labelId, new PageRequest(page, size));
        log.debug("标签id=>[{}]，问题=>[{}]", labelId, list);
        return list;
    }

    public Page<Problem> findWaitListByLabelId(String labelId, int page, int size){
        Page<Problem> list = problemDao.findWaitListByLabelId(labelId, new PageRequest(page, size));
        log.debug("标签id=>[{}]，问题=>[{}]", labelId, list);
        return list;
    }
}
