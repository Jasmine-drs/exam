package com.drs.shangxuan.controller;

import com.drs.shangxuan.bean.Department;
import com.drs.shangxuan.bean.School;
import com.drs.shangxuan.common.R;
import com.drs.shangxuan.service.imp.SchoolServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/8/26 9:27
 */
@RestController
@RequestMapping("/schools")
public class SchoolController {

    SchoolServiceImp schoolServiceImp;

    public SchoolController(SchoolServiceImp serviceImp) {
        this.schoolServiceImp = serviceImp;
    }

    @GetMapping
    public R<List<Department>> selectById(String id) {
        System.out.println("value = " + id);
        List<Department> departments = schoolServiceImp.selectById(id);
        if (departments == null) {
            return R.err("不存在");
        }
        return R.success(departments);
    }

    @GetMapping("/{id}")
    public R<String> updateStatus(@PathVariable String id) {
        Boolean aBoolean = schoolServiceImp.updateStatus(id);
        if (aBoolean) {
            return R.success("修改成功");
        }
        return R.err("修改失败");
    }

    @PostMapping
    public R<String> save(@RequestBody School school) {
        System.out.println("school = " + school);
        boolean save = schoolServiceImp.save(school);
        if (save) {
            return R.success("成功");
        }
        return R.err("增加失败");
    }
}
