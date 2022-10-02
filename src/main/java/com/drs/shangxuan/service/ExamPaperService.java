package com.drs.shangxuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.drs.shangxuan.bean.ExamPaper;
import com.drs.shangxuan.bean.Question;

import java.util.ArrayList;

/**
 * @author Jasmine-drs
 * @date 2022/9/7 9:25
 */
public interface ExamPaperService extends IService<ExamPaper> {
    Boolean deleteById(Integer id, Integer flag, Integer examId);

    Boolean sava(ExamPaper examPaper);

    ArrayList<Question> selectByExamId(String examId);
}
