package com.drs.shangxuan.controller;

import com.drs.shangxuan.bean.Classes;
import com.drs.shangxuan.bean.Department;
import com.drs.shangxuan.common.R;
import com.drs.shangxuan.service.imp.DepartmentServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/8/26 9:27
 */
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    DepartmentServiceImp departmentServiceImp;

    public DepartmentController(DepartmentServiceImp departmentServiceImp) {
        this.departmentServiceImp = departmentServiceImp;
    }

    @GetMapping
    public R<List<Classes>> selectById(String id) {
        System.out.println("id = " + id);
        List<Classes> classes = departmentServiceImp.selectById(id);
        if (classes == null) {
            return R.err("不存在");
        }
        return R.success(classes);
    }

    @GetMapping("/{id}")
    public R<String> updateStatus(@PathVariable String id) {
        Boolean aBoolean = departmentServiceImp.updateStatus(id);
        if (aBoolean) {
            return R.success("修改成功");
        }
        return R.err("修改失败");
    }

    @PostMapping
    public R<String> save(@RequestBody Department department) {
        System.out.println("department = " + department);
        boolean save = departmentServiceImp.save(department);
        if (save) {
            return R.success("成功");
        }
        return R.err("增加失败");
    }
}
