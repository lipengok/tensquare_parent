package base.com.lp.service.impl;

import base.com.lp.dao.LabelDao;
import base.com.lp.pojo.Label;
import base.com.lp.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author lipeng
 * @Date 2022/11/15 15:45
 * @Version 1.0
 */
@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelDao labelDao;

    public List<Label> findAll() {
        List<Label> list = labelDao.findAll();
        return list;
    }

    @Override
    public List<Label> search(Map SearchMap) {
        Specification specification = createSpecification(SearchMap);
        List<Label> list = labelDao.findAll(specification);
        return list;
    }

    @Override
    public Page<Label> searchPage(Map SearchMap, int page, int size) {
        Specification specification = createSpecification(SearchMap);
        PageRequest pageRequest = new PageRequest(page, size);
        return labelDao.findAll(specification, pageRequest);
    }

    /**
     * 构建查询条件
     *
     * @param searchMap
     * @return
     */
    private Specification<Label> createSpecification(Map searchMap) {
        return new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<>();
                if (searchMap.get("labelname") != null && !"".equals(searchMap.get("labelname"))) {
                    predicateList.add(cb.like(root.get("labelname").as(String.class), "%" + (String) searchMap.get("labelname") + "%"));
                }
                if (searchMap.get("state") != null && !"".equals(searchMap.get("state"))) {
                    predicateList.add(cb.equal(root.get("state").as(String.class), (String) searchMap.get("state")));
                }
                if (searchMap.get("recommend") != null && !"".equals(searchMap.get("recommend"))) {
                    predicateList.add(cb.equal(root.get("recommend").as(String.class), (String) searchMap.get("recommend")));
                }
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
    }


}
