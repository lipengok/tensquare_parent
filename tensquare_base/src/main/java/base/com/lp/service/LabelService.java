package base.com.lp.service;

import base.com.lp.pojo.Label;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * 标签服务
 * @Author lipeng
 * @Date 2022/11/16 11:08
 * @Version 1.0
 */
public interface LabelService {

    // 查询所有标签信息
    List<Label> findAll();

    // 根据查询条件查询标签信息
    List<Label> search(Map SearchMap);

    // 根据查询条件查询标签信息，并且分页
    Page<Label> searchPage(Map SearchMap, int page, int size);
}
