package com.drs.shangxuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.drs.shangxuan.bean.Exam;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/9/7 9:25
 */
public interface ExamService extends IService<Exam> {
    Integer saveAndReturnId(Exam exam);

    List<Exam> selectByName(String nickName);
}
