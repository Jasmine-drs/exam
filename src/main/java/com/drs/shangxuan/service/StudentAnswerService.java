package com.drs.shangxuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.drs.shangxuan.bean.StudentAnswer;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/9/13 9:16
 */
public interface StudentAnswerService extends IService<StudentAnswer> {
    Boolean saveAndUpdate(StudentAnswer answer);

    List<StudentAnswer> selectByNickName(String nickName, Integer examId);
}
