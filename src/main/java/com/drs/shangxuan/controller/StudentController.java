package com.drs.shangxuan.controller;

import com.drs.shangxuan.bean.Student;
import com.drs.shangxuan.common.R;
import com.drs.shangxuan.service.imp.StudentServiceImp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/9/13 16:00
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    StudentServiceImp studentServiceImp;

    public StudentController(StudentServiceImp studentServiceImp) {
        this.studentServiceImp = studentServiceImp;
    }

    @GetMapping
    public R<List<Student>> selectAll() {
        List<Student> students = studentServiceImp.selectAll();
        return R.success(students);
    }
}
