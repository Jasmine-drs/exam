package com.drs.shangxuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.drs.shangxuan.bean.Result;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/9/14 13:25
 */
public interface ResultService extends IService<Result> {
    List<Result> selectByNickName(String nickName);
}
