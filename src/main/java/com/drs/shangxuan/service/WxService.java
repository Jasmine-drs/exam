package com.drs.shangxuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.drs.shangxuan.bean.Student;

/**
 * @author Jasmine-drs
 * @date 2022/8/18 17:51
 */
public interface WxService extends IService<Student> {
    String loginByWx(String code);

    Student save(String nickName, String avatarUrl);

    //    void putUserInfo(String nickName, String value, Integer flag);
    void putUserInfo(Student student);
}
