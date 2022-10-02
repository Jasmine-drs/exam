package com.drs.shangxuan.controller;

import com.drs.shangxuan.bean.Classes;
import com.drs.shangxuan.common.R;
import com.drs.shangxuan.service.imp.ClassesServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jasmine-drs
 * @date 2022/8/29 19:25
 */
@Slf4j
@RequestMapping("/classes")
@RestController
public class ClassesController {

    ClassesServiceImp classesServiceImp;

    public ClassesController(ClassesServiceImp classesServiceImp) {
        this.classesServiceImp = classesServiceImp;
    }

    @GetMapping("/{id}")
    public R<String> updateStatus(@PathVariable String id) {
        Boolean aBoolean = classesServiceImp.updateStatus(id);
        if (aBoolean) {
            return R.success("修改成功");
        }
        return R.err("修改失败");
    }

    @PostMapping
    public R<String> save(@RequestBody Classes classes) {
        System.out.println("classes = " + classes);
        boolean save = classesServiceImp.save(classes);
        if (save) {
            return R.success("成功");
        }
        return R.err("增加失败");
    }
}
