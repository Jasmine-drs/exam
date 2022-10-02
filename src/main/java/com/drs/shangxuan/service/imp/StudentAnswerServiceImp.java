package com.drs.shangxuan.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.drs.shangxuan.bean.ExamPaper;
import com.drs.shangxuan.bean.StudentAnswer;
import com.drs.shangxuan.mapper.ExamPaperMapper;
import com.drs.shangxuan.mapper.StudentAnswerMapper;
import com.drs.shangxuan.service.StudentAnswerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/9/13 9:16
 */
@Service
@Slf4j
public class StudentAnswerServiceImp extends ServiceImpl<StudentAnswerMapper, StudentAnswer> implements StudentAnswerService {

    final
    ExamPaperMapper examPaperMapper;
    StudentAnswerMapper answerMapper;

    public StudentAnswerServiceImp(StudentAnswerMapper answerMapper, ExamPaperMapper examPaperMapper) {
        this.answerMapper = answerMapper;
        this.examPaperMapper = examPaperMapper;
    }

    /**
     * 用于学生答案的保存以及更新
     *
     * @param answer 学生答案实例
     * @return 是否成功
     */
    @Override
    public Boolean saveAndUpdate(StudentAnswer answer) {
//        构造查询条件
        HashMap<String, Object> map = new HashMap<>();
        map.put("question_id", answer.questionId);
        map.put("exam_id", answer.examId);
        map.put("type", answer.type);
        map.put("nick_name", answer.nickName);

        List<StudentAnswer> studentAnswers = answerMapper.selectByMap(map);
//        构造条件，查询examPaper里面的排序字段
        map.remove("nick_name");
//        map.put("exam_id", answer.examId);
//        将查到的排序，设置给对应的学生答案
        List<ExamPaper> examPapers = examPaperMapper.selectByMap(map);
//        根据Sequence排序
        examPapers.sort(Comparator.comparingInt(ExamPaper::getSequence));

        for (ExamPaper examPaper : examPapers) {
//            StudentAnswer studentAnswer = studentAnswers.get(j);
            answer.setSequence(examPaper.sequence);
        }
//        如果studentAnswers为空，则执行插入
        if (studentAnswers.size() == 0) {
            int insert = answerMapper.insert(answer);
            return insert == 1;
        }
//        如果已经存在该条记录，则更新答案
        studentAnswers.get(0).setAnswer(answer.answer);
        int i = answerMapper.updateById(studentAnswers.get(0));
        return i == 1;
    }

    /**
     * 获取特定学生的特定试卷的答案
     *
     * @param nickName 学生昵称
     * @param examId   试卷id
     * @return 学生答案集合
     */
    @Override
    public List<StudentAnswer> selectByNickName(String nickName, Integer examId) {
        HashMap<String, Object> map = new HashMap<>();
//        构造查询条件
        map.put("exam_id", examId);
        map.put("nick_name", nickName);

        List<StudentAnswer> studentAnswers = answerMapper.selectByMap(map);
//        设置提示
        if (studentAnswers.size() == 0) {
            log.error("studentAnswers is null");
        }
//        studentAnswers.sort((x,y)->Integer.compare(x.type,y.type));
//        自定义排序规则，按照学生答案对应的顺序，与返回小程序端的examPaper一致
        studentAnswers.sort(Comparator.comparingInt(StudentAnswer::getSequence));
//        studentAnswers.sort(Comparator.comparingInt(x -> x.type));
        log.info(studentAnswers.toString());
        return studentAnswers;
    }
}
