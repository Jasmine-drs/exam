package com.drs.shangxuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.drs.shangxuan.bean.Classes;

/**
 * @author Jasmine-drs
 * @date 2022/8/29 19:28
 */
public interface ClassesService extends IService<Classes> {
    Boolean updateStatus(String id);
}
