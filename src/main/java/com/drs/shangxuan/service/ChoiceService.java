package com.drs.shangxuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.drs.shangxuan.bean.Choice;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/9/4 9:43
 */
public interface ChoiceService extends IService<Choice> {
    List<Choice> selectAll();

    Boolean deleteById(String id);

    Choice selectById(String id);
}
