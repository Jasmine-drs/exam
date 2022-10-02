package com.drs.shangxuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.drs.shangxuan.bean.Judgment;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/9/4 9:43
 */
public interface JudgmentService extends IService<Judgment> {
    List<Judgment> selectAll();

    Boolean deleteById(String id);

    Judgment selectById(String id);
}
