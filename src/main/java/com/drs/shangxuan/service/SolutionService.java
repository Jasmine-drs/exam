package com.drs.shangxuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.drs.shangxuan.bean.Solution;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/9/4 9:43
 */
public interface SolutionService extends IService<Solution> {
    List<Solution> selectAll();

    Boolean deleteById(String id);

    Solution selectById(String id);
}
