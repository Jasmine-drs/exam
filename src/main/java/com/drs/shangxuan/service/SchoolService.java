package com.drs.shangxuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.drs.shangxuan.bean.Department;
import com.drs.shangxuan.bean.School;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/8/26 9:29
 */
public interface SchoolService extends IService<School> {
    List<Department> selectById(String value);

    Boolean updateStatus(String id);
}
