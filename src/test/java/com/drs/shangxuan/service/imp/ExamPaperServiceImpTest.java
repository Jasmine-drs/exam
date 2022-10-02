package com.drs.shangxuan.service.imp;

import com.drs.shangxuan.bean.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest
class ExamPaperServiceImpTest {

    @Autowired
    ExamPaperServiceImp examPaperServiceImp;

    /**
     * 测试自定义排序
     */
    @Test
    void selectByExamId() {
        ArrayList<Question> questionList = examPaperServiceImp.selectByExamId("1451741185");
        System.out.println(Arrays.toString(questionList.toArray()));
    }
}