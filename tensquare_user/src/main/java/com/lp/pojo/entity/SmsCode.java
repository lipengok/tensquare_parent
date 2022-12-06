package com.lp.pojo.entity;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/12/6 14:37
 * @Version 1.0
 */
@Data
public class SmsCode {
    public SmsCode(String mobile) {
        this.mobile = mobile;
    }

    private String mobile;
}
