package com.drs.shangxuan.controller;

import com.drs.shangxuan.bean.ExamPaper;
import com.drs.shangxuan.bean.Question;
import com.drs.shangxuan.common.R;
import com.drs.shangxuan.service.imp.ExamPaperServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/9/7 10:07
 */
@RequestMapping("/examPapers")
@RestController
public class ExamPaperController {

    ExamPaperServiceImp examPaperServiceImp;

    public ExamPaperController(ExamPaperServiceImp examPaperServiceImp) {
        this.examPaperServiceImp = examPaperServiceImp;
    }

    @PostMapping
    public R<Integer> save(@RequestBody ExamPaper examPaper) {
        System.out.println("list1 = " + examPaper);
        Boolean sava = examPaperServiceImp.sava(examPaper);
        if (sava) {
            return R.success(examPaper.getExamId());
        }
        return R.err("失败");
    }

    @DeleteMapping
    public R<String> deleteById(Integer id, Integer flag, Integer examId) {
        System.out.println("id = " + id);
        System.out.println("flag = " + flag);
        System.out.println("examId = " + examId);//三个条件共同查询
        Boolean aBoolean = examPaperServiceImp.deleteById(id, flag, examId);
        if (aBoolean) {
            return R.success("成功");
        }
        return R.err("没有该题目可删除");
    }

    @GetMapping("/{examId}")
    public R<List<Question>> selectByExamId(@PathVariable String examId) {
        System.out.println("examId = " + examId);
        ArrayList<Question> questionList = examPaperServiceImp.selectByExamId(examId);
        if (questionList.size() == 0) {
            return R.err("该试卷暂时没有题目");
        }
        return R.success(questionList);
    }
}

