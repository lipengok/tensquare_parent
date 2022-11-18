package common.com.lp.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/11/15 15:43
 * @Version 1.0
 */
@Data
public class PageResult<T> {

    private Long total;
    private List<T> rows;

    public PageResult() {
    }

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
}
