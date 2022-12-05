package com.lp.server.impl;

import com.lp.dao.AdminDao;
import com.lp.pojo.Admin;
import com.lp.server.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author lipeng
 * @Date 2022/12/5 10:40
 * @Version 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    /**
     * 添加管理员
     *
     * @param admin
     */
    public void add(Admin admin) {
        admin.setId(admin.getId());
        //密码加密
        String newPwd = encoder.encode(admin.getPsw());
        //加密后的密码
        admin.setPsw(newPwd);
        adminDao.save(admin);
    }

    /**
     * 管理员登录
     *
     * @param name
     * @param psw
     * @return
     */
    public Admin findByNameAndPsw(String name, String psw) {
        Admin admin = adminDao.findByName(name);
        if (admin != null && encoder.matches(psw, admin.getPsw())) {
            return admin;
        } else {
            return null;
        }
    }
}
