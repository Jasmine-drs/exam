package com.drs.shangxuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.drs.shangxuan.bean.User;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/8/4 18:12
 */
public interface UserService extends IService<User> {
    User login(String name, String pwd);

    User selectById(int id);

    List<User> select(String value);

    boolean updateByStatus(int id);

    int insertUser(User user);
}
