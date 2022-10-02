package com.drs.shangxuan.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.drs.shangxuan.bean.Classes;
import com.drs.shangxuan.bean.Exam;
import com.drs.shangxuan.bean.School;
import com.drs.shangxuan.bean.Student;
import com.drs.shangxuan.mapper.*;
import com.drs.shangxuan.service.ExamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/9/7 9:26
 */
@Service
@Slf4j
public class ExamServiceImp extends ServiceImpl<ExamMapper, Exam> implements ExamService {

    ExamMapper examMapper;
    StudentMapper studentMapper;
    SchoolMapper schoolMapper;
    ClassesMapper classesMapper;
    UserMapper userMapper;

    public ExamServiceImp(ExamMapper examMapper, StudentMapper studentMapper, SchoolMapper schoolMapper, ClassesMapper classesMapper, UserMapper userMapper) {
        this.examMapper = examMapper;
        this.studentMapper = studentMapper;
        this.schoolMapper = schoolMapper;
        this.classesMapper = classesMapper;
        this.userMapper = userMapper;
    }

    /**
     * 插入试卷基本信息以及返回该试卷信息的id
     *
     * @param exam 试卷信息实体类
     * @return id
     */
    @Override
    public Integer saveAndReturnId(Exam exam) {
        examMapper.insert(exam);
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", exam.getName());
        List<Exam> exams = examMapper.selectByMap(map);
        if (exams == null) {
            log.error("exam is null");
            return null;
        }
        return exams.get(0).getId();
    }

    @Override
    public List<Exam> selectByName(String nickName) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("nick_name", nickName);
//        获取该学生所属组织
        List<Student> students = studentMapper.selectByMap(map);
        if (students.size() == 0) {
//            没找到学生，直接找老师，适应批改页面的需求
            map.remove("nick_name");
            map.put("operator", nickName);
            List<Exam> exams = examMapper.selectByMap(map);
            if (exams.size() == 0) {
                return new ArrayList<>();
            }
            return exams;
        }
//        查询二级组织学校
        map.remove("nick_name");
        map.put("name", students.get(0).getSchool());
        List<School> schools = schoolMapper.selectByMap(map);
//        查询四级组织班级
        map.put("name", students.get(0).getClasses());
        log.info(map.toString());
        List<Classes> classes = classesMapper.selectByMap(map);
//        构造查询条件
        QueryWrapper<Exam> wrapper = new QueryWrapper<>();
        wrapper.eq("tertiary_organization", schools.get(0).id)
                .eq("four_organization", classes.get(0).id);

        return examMapper.selectList(wrapper);
    }
}
