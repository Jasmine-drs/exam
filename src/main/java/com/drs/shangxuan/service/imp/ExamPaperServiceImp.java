package com.drs.shangxuan.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.drs.shangxuan.bean.*;
import com.drs.shangxuan.mapper.ChoiceMapper;
import com.drs.shangxuan.mapper.ExamPaperMapper;
import com.drs.shangxuan.mapper.JudgmentMapper;
import com.drs.shangxuan.mapper.SolutionMapper;
import com.drs.shangxuan.service.ExamPaperService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/9/7 9:27
 */
@Service
@Slf4j
public class ExamPaperServiceImp extends ServiceImpl<ExamPaperMapper, ExamPaper> implements ExamPaperService {

    ChoiceMapper choiceMapper;
    JudgmentMapper judgmentMapper;
    SolutionMapper solutionMapper;
    ExamPaperMapper examPaperMapper;

    public ExamPaperServiceImp(ChoiceMapper choiceMapper, JudgmentMapper judgmentMapper, SolutionMapper solutionMapper, ExamPaperMapper examPaperMapper) {
        this.choiceMapper = choiceMapper;
        this.judgmentMapper = judgmentMapper;
        this.solutionMapper = solutionMapper;
        this.examPaperMapper = examPaperMapper;
    }

    /**
     * 通过flag、id查找examPaper从而删除
     *
     * @param id   题目id
     * @param flag 题目类型
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteById(Integer id, Integer flag, Integer examId) {
        if (flag == 1 || flag == 2 || flag == 3) {
            Boolean i = getaBoolean(id, flag, examId);
            if (i != null)
                return i;
        } else {
            log.error("flag is error");
            return false;
        }
        return true;
    }

    /**
     * 用于删除题目的条件构造
     *
     * @param id   题目id
     * @param flag 题目类型
     * @return 是否删除成功
     */
    @Nullable
    private Boolean getaBoolean(Integer id, Integer flag, Integer examId) {
        QueryWrapper<ExamPaper> wrapper = new QueryWrapper<>();
        wrapper
                .eq("question_id", id)
                .eq("exam_id", examId)
                .eq("type", flag);
        ExamPaper examPaper = examPaperMapper.selectOne(wrapper);
        if (examPaper != null) {
            int i = examPaperMapper.deleteById(examPaper);
            return i != 0;
        }
        return null;
    }

    /**
     * 保存新的题目信息
     *
     * @param examPaper 题目信息实体类
     * @return 是否保存成功
     */
    @Override
    public Boolean sava(ExamPaper examPaper) {
        System.out.println("examPaper = " + examPaper);
        QueryWrapper<ExamPaper> wrapper = new QueryWrapper<>();
        wrapper
                .eq("question_id", examPaper.getQuestionId())
                .eq("exam_id", examPaper.getExamId())
                .eq("type", examPaper.getType());
        List<ExamPaper> examPaper1 = examPaperMapper.selectList(wrapper);
        if (examPaper1.size() == 0) {
            int insert = examPaperMapper.insert(examPaper);
            return insert != 0;
        }
        return true;
    }

    /**
     * 通过与exam表关联的exam_id字段查找到属于同一张试卷的具体题目
     *
     * @param examId 与exam表关联的字段
     * @return examPaper集合
     */
    @Override
    public ArrayList<Question> selectByExamId(String examId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("exam_id", Integer.parseInt(examId));

        List<ExamPaper> examPapers = examPaperMapper.selectByMap(map);
//        根据题目顺序进行排序
        examPapers.sort(Comparator.comparingInt(ExamPaper::getSequence));
//        获取examPaper里面的questionId以及题目类型
        ArrayList<Integer> questionIdList = new ArrayList<>();
        ArrayList<Integer> typeList = new ArrayList<>();
//        最后组合成题目集合
        ArrayList<Question> questionList = new ArrayList<>();
        for (ExamPaper examPaper : examPapers) {
            typeList.add(examPaper.type);
            questionIdList.add(examPaper.questionId);
        }
        log.info(questionIdList.toString(), 121);
        log.info(typeList.toString(), 122);
//        根据不同的题目类型，查找不同的表
        for (int i = 0; i < examPapers.size(); i++) {
            if (typeList.get(i) == 1) {
                Choice choice = choiceMapper.selectById(questionIdList.get(i));
                questionList.add(choice);
            } else if (typeList.get(i) == 2) {
                Judgment judgment = judgmentMapper.selectById(questionIdList.get(i));
                questionList.add(judgment);
            } else if (typeList.get(i) == 3) {
                Solution solution = solutionMapper.selectById(questionIdList.get(i));
                questionList.add(solution);
            } else {
                log.error("type is illegal");
                return new ArrayList<>();
            }
        }
//        自定义排序，根据题目类型，从小到大，相同类型的题目在一起
//        questionList.sort(Comparator.comparingInt(Question::getType));
        return questionList;
    }
}
