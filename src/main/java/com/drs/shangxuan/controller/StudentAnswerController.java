package com.drs.shangxuan.controller;

import com.drs.shangxuan.bean.StudentAnswer;
import com.drs.shangxuan.common.R;
import com.drs.shangxuan.service.imp.StudentAnswerServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/9/13 9:14
 */
@RestController
@RequestMapping("/studentAnswers")
public class StudentAnswerController {

    StudentAnswerServiceImp answerServiceImp;

    public StudentAnswerController(StudentAnswerServiceImp answerServiceImp) {
        this.answerServiceImp = answerServiceImp;
    }

    @PostMapping
    public R<String> save(@RequestBody StudentAnswer answer) {
        System.out.println("answer = " + answer);
        Boolean aBoolean = answerServiceImp.saveAndUpdate(answer);
        if (aBoolean) {
            return R.success("成功");
        }
        return R.err("答案添加失败");
    }

    @GetMapping
    public R<List<StudentAnswer>> selectByNickName(String nickName, Integer examId) {
        System.out.println("StudentAnswerController.selectByNickName");
        System.out.println("nickName = " + nickName);
        System.out.println("examId = " + examId);

        List<StudentAnswer> studentAnswers = answerServiceImp.selectByNickName(nickName, examId);
        return R.success(studentAnswers);
    }
}
