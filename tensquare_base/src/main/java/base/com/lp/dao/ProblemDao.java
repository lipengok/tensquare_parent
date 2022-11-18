package base.com.lp.dao;

import base.com.lp.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author lipeng
 * @Date 2022/11/18 10:09
 * @Version 1.0
 */
public interface ProblemDao extends JpaRepository<Problem, String>, JpaSpecificationExecutor<Problem> {

    /**
     * 根据标签ID查询最新问题列表
     * @param labelId
     * @param pageRequest
     * @return
     */
    @Query("select p from Problem p where id in( select problemid from Pl where labelid =?1) order by replytime desc")
    Page<Problem> findNewListByLabelId(String labelId, Pageable pageRequest);

    /**
     * 根据标签ID查询热门问题列表
     * @param labelId
     * @param pageRequest
     * @return
     */
    @Query("select p from Problem p where id in( select problemid from Pl where labelid=?1 ) order by reply desc")
    Page<Problem> findHotListByLabelId(String labelId, Pageable pageRequest);

    /**
     * 根据标签ID查询最新等待回答列表
     * @param labelId
     * @param pageRequest
     * @return
     */
    @Query("select p from Problem p where id in( select problemid from Pl where labelid=?1 ) and reply=0 order by createtime desc")
    Page<Problem> findWaitListByLabelId(String labelId, Pageable pageRequest);
}
