package com.drs.shangxuan.controller;

import com.drs.shangxuan.bean.Exam;
import com.drs.shangxuan.common.R;
import com.drs.shangxuan.service.imp.ExamServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/9/7 9:29
 */
@RestController
@RequestMapping("/exams")
public class ExamController {

    ExamServiceImp examServiceImp;

    public ExamController(ExamServiceImp examServiceImp) {
        this.examServiceImp = examServiceImp;
    }

    @PostMapping
    public R<Integer> save(@RequestBody Exam exam) {
        System.out.println("exam = " + exam);
//        这个试卷保存总会出现id超出int范围的情况
        int random = (int) (Math.random() * 10000);
        exam.setId(random);
        System.out.println(random);
        Integer integer = examServiceImp.saveAndReturnId(exam);
        if (integer == null) {
            return R.err("失败");
        }
        return R.success(integer);
    }

    @GetMapping("/{nickName}")
    public R<List<Exam>> selectByName(@PathVariable String nickName) {
        System.out.println("nickName = " + nickName);
        List<Exam> exams = examServiceImp.selectByName(nickName);
        if (exams.size() == 0) {
            return R.err("没有试卷");
        }
        return R.success(exams);
    }
}
