package com.drs.shangxuan.controller;

import com.drs.shangxuan.bean.User;
import com.drs.shangxuan.common.R;
import com.drs.shangxuan.service.imp.UserServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author Jasmine-drs
 * @date 2022/8/4 18:12
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserServiceImp serviceImp;

    public UserController(UserServiceImp serviceImp) {
        this.serviceImp = serviceImp;
    }

    /**
     * 用户登录
     *
     * @param name 账号
     * @param pwd  密码
     * @return 自定义登录态以及用户信息
     */
    @PostMapping("/{name}/{pwd}")
    public R<User> login(@PathVariable String name, @PathVariable String pwd) {
        System.out.println("pwd = " + pwd);
        log.info("页面访问成功");
        User user = serviceImp.login(name, pwd);
        if (user != null) {
            return R.success(user);
        } else {
            return R.err("账号或密码错误");
        }
    }

    /**
     * 通过id查询用户信息
     *
     * @param id 用户id
     * @return 自定义登录态以及用户信息
     */
    @GetMapping("/{id}")
    public R<User> selectById(@PathVariable int id) {
        User user = serviceImp.selectById(id);
        if (user != null) {
            return R.success(user);
        }
        return R.err("查无此人");
    }

    /**
     * 查询用户信息，实现了多字段的模糊查询、查询所有
     *
     * @param value 所查询的内容
     * @return 查询到的list用户集合
     */
    @PostMapping("/search")
    public R<List<User>> select(String value) {
        System.out.println("value = " + value);
        List<User> users = serviceImp.select(value);
        if (users.size() != 0) {
            return R.success(users);
        }
        return R.err("没找到");
    }

    @PostMapping
    public R<String> insertUser(User user) {
        System.out.println("user = " + user);
        String name = user.getName();
        String userName = user.getUserName();
        String password = user.getPassword();
        String sex = user.getSex();
        Integer age = user.getAge();
        String phone = user.getPhone();
        Integer type = user.getType();
        /*非空校验*/
        if (Objects.equals(name, "")) {
            return R.err("姓名为空");
        } else if (Objects.equals(userName, "")) {
            return R.err("账号为空");
        } else if (Objects.equals(password, "")) {
            return R.err("密码为空");
        } else if (Objects.equals(sex, null)) {
            return R.err("性别为空");
        } else if (Objects.equals(age, null)) {
            return R.err("年龄为空");
        } else if (Objects.equals(phone, "")) {
            return R.err("电话为空");
        } else if (Objects.equals(type, null)) {
            return R.err("账号类型为空");
        }
        /*插入*/
        int i = serviceImp.insertUser(user);
        if (i == 1) {
            return R.success("添加成功");
        } else if (i == 2) {
            return R.success("修改成功");
        }
        return R.err("添加失败");
    }

    /**
     * 修改员工账号状态
     *
     * @param id 员工id
     * @return 自定义状态
     */
    @PutMapping("/{id}")
    public R<String> updateByStatus(@PathVariable String id) {
        System.out.println("id = " + id);
        int i = 0;
        try {
            i = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return R.err("id转化异常");
        }
        System.out.println(i);
        boolean b = serviceImp.updateByStatus(i);
        if (b) {
            return R.success("修改成功");
        }
        return R.err("失败");
    }
}
