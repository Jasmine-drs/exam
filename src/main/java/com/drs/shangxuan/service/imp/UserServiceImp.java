package com.drs.shangxuan.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.drs.shangxuan.bean.User;
import com.drs.shangxuan.mapper.UserMapper;
import com.drs.shangxuan.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author Jasmine-drs
 * @date 2022/8/4 18:13
 */
@Service
public class UserServiceImp extends ServiceImpl<UserMapper, User> implements UserService {
    private UserMapper userMapper;

    public UserServiceImp(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User login(String name, String pwd) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_name", name);
        map.put("password", pwd);
        List<User> users = userMapper.selectByMap(map);
        if (users.size() != 0) {
            return users.get(0);
        }
        return null;
    }

    public User selectById(int id) {
        return userMapper.selectById(id);
    }

    public List<User> select(String value) {
        /*用于查询全部*/
        if (value.equals("")) {
            System.out.println("查询所有");
            return userMapper.selectList(null);
        }
        /*专用于账号状态查询*/
        if (value.equals("启用") || value.equals("禁用")) {
            System.out.println("查询账号状态");
            HashMap<String, Object> map = new HashMap<>();
            int t = 0;// status：0 代表禁用，1 代表启用
            if (value.equals("启用")) {
                t = 1;
            }
            map.put("status", t);
            return userMapper.selectByMap(map);
        }
        /*一般的模糊查询*/
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .like("name", value).or()
                .eq("age", value).or()
                .eq("sex", value).or()
                .like("phone", value);
        return userMapper.selectList(wrapper);
    }

    public boolean updateByStatus(int id) {
        User user = userMapper.selectById(id);
        if (user == null) {
            return false;
        }
        int t = 0;
        if (user.getStatus() == 1) {
            user.setStatus(0);
        } else {
            user.setStatus(1);
        }
        t = userMapper.updateById(user);
        return t == 1;
    }

    public int insertUser(User user) {
        String sex = user.getSex();
        if (Objects.equals(sex, "1")) {
            user.setSex("男");
        } else {
            user.setSex("女");
        }
        String userName = user.getUserName();
        HashMap<String, Object> map = new HashMap<>();
        /*检验userName是否存在*/
        map.put("user_name", userName);
        List<User> users = userMapper.selectByMap(map);
        if (users.size() == 0) {
            return userMapper.insert(user);
        } else {
            user.setId(users.get(0).getId());
            userMapper.updateById(user);
            return 2;
        }
    }
}
