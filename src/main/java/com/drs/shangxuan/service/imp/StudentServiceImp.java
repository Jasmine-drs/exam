package com.drs.shangxuan.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.drs.shangxuan.bean.Student;
import com.drs.shangxuan.mapper.StudentMapper;
import com.drs.shangxuan.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/9/13 16:03
 */
@Service
public class StudentServiceImp extends ServiceImpl<StudentMapper, Student> implements StudentService {

    StudentMapper studentMapper;

    public StudentServiceImp(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    /**
     * 查询所有学生
     *
     * @return 学生集合
     */
    @Override
    public List<Student> selectAll() {
        return studentMapper.selectByMap(null);
    }
}
