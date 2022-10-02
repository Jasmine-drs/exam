package com.drs.shangxuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.drs.shangxuan.bean.Classes;
import com.drs.shangxuan.bean.Department;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/8/26 9:29
 */
public interface DepartmentService extends IService<Department> {
    List<Classes> selectById(String id);

    Boolean updateStatus(String id);
}
