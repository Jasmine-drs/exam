package com.drs.shangxuan.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.drs.shangxuan.bean.Department;
import com.drs.shangxuan.bean.School;
import com.drs.shangxuan.mapper.DepartmentMapper;
import com.drs.shangxuan.mapper.SchoolMapper;
import com.drs.shangxuan.service.SchoolService;
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
public class SchoolServiceImp extends ServiceImpl<SchoolMapper, School> implements SchoolService {

    SchoolMapper schoolMapper;

    DepartmentMapper departmentMapper;

    public SchoolServiceImp(SchoolMapper schoolMapper, DepartmentMapper departmentMapper) {
        this.schoolMapper = schoolMapper;
        this.departmentMapper = departmentMapper;
    }

    /**
     * 通过查找上一组织获取indexesBottom来查找对应的下级组织
     *
     * @param id 上级组织的id
     * @return 下级组织集合
     */
    @Override
    public List<Department> selectById(String id) {
        int i = Integer.parseInt(id);
        School school = schoolMapper.selectById(i);
//        判断是否查到
        if (school == null) {
            log.error("school is null");
            return null;
        }
//        判断是否删除
        if (school.getStatus() == 0) {
            log.error("school-status is abolish");
            return null;
        }
//        获取下级组织索引
        Integer indexBottom = school.getIndexBottom();
        //        添加查询条件
        HashMap<String, Object> map = new HashMap<>();
        map.put("indexes", indexBottom);

        List<Department> departments = departmentMapper.selectByMap(map);
//        判断是否存在
        if (departments == null) {
            log.error("departments is null");
            return null;
        }
        return departments;
    }

    /**
     * 修改组织状态
     *
     * @param id 该组织的id
     * @return 是否修改成功
     */
    @Override
    public Boolean updateStatus(String id) {
        School school = schoolMapper.selectById(Integer.parseInt(id));
        if (school == null) {
            log.error("school is null -- update failed");
            return false;
        }
        if (school.getStatus() == 1) {
            school.setStatus(0);
        } else {
            school.setStatus(1);
        }
        int i = schoolMapper.updateById(school);
        return i != 0;
    }

    /**
     * 保存添加的组织
     *
     * @param entity 组织实例
     * @return 是否添加成功
     */
    @Override
    public boolean save(School entity) {
        if (entity.getIndexes() == null && entity.getIndexBottom() == null) {
            return false;
        }
        return super.save(entity);
    }
}
