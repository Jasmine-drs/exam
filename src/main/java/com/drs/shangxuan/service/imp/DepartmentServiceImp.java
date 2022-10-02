package com.drs.shangxuan.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.drs.shangxuan.bean.Classes;
import com.drs.shangxuan.bean.Department;
import com.drs.shangxuan.mapper.ClassesMapper;
import com.drs.shangxuan.mapper.DepartmentMapper;
import com.drs.shangxuan.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/8/26 9:30
 */
@Service
@Slf4j
public class DepartmentServiceImp extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    DepartmentMapper departmentMapper;
    ClassesMapper classesMapper;

    public DepartmentServiceImp(DepartmentMapper departmentMapper, ClassesMapper classesMapper) {
        this.departmentMapper = departmentMapper;
        this.classesMapper = classesMapper;
    }

    @Override
    public List<Classes> selectById(String id) {
        Department department = departmentMapper.selectById(id);
        if (department == null) {
            log.error("department is null");
            return null;
        }
//        检查是否被弃用
        if (department.getStatus() == 0) {
            log.error("department is abolished");
            return null;
        }
//        获取下级组织索引
        Integer indexBottom = department.getIndexBottom();
//        构造查找条件
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("indexes", indexBottom);
        List<Classes> classes = classesMapper.selectByMap(hashMap);
//        判断是否为空
        if (classes == null) {
            log.error("classes is null");
            return null;
        }
        return classes;
    }

    @Override
    public Boolean updateStatus(String id) {
        Department department = departmentMapper.selectById(Integer.parseInt(id));
//        判断非空
        if (department == null) {
            log.error("department is null -- update failed");
            return false;
        }
//        修改状态
        if (department.getStatus() == 1) {
            department.setStatus(0);
        } else {
            department.setStatus(1);
        }
        int i = departmentMapper.updateById(department);
        return i != 0;
    }

    @Override
    public boolean save(Department entity) {
        if (entity.getIndexes() == null && entity.getIndexBottom() == null) {
            return false;
        }
        return super.save(entity);
    }
}
