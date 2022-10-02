package com.drs.shangxuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.drs.shangxuan.bean.Student;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/9/13 16:03
 */
public interface StudentService extends IService<Student> {
    List<Student> selectAll();
}
