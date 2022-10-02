package com.drs.shangxuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.drs.shangxuan.bean.Area;
import com.drs.shangxuan.bean.School;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/8/26 9:29
 */
public interface AreaService extends IService<Area> {
    List<School> selectById(String id);

    List<Area> selectAll(String value);

    Boolean selectAreaById(String id);
}
