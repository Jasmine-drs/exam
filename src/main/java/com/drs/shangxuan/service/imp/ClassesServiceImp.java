package com.drs.shangxuan.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.drs.shangxuan.bean.Classes;
import com.drs.shangxuan.mapper.ClassesMapper;
import com.drs.shangxuan.service.ClassesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Jasmine-drs
 * @date 2022/8/29 19:29
 */
@Service
@Slf4j
public class ClassesServiceImp extends ServiceImpl<ClassesMapper, Classes> implements ClassesService {

    ClassesMapper classesMapper;

    public ClassesServiceImp(ClassesMapper classesMapper) {
        this.classesMapper = classesMapper;
    }

    @Override
    public Boolean updateStatus(String id) {
        Classes classes = classesMapper.selectById(Integer.parseInt(id));
        if (classes == null) {
            log.error("classes is null -- update failed");
            return false;
        }
//        修改状态
        if (classes.getStatus() == 1) {
            classes.setStatus(0);
        } else {
            classes.setStatus(1);
        }
        int i = classesMapper.updateById(classes);
        return i != 0;
    }

    @Override
    public boolean save(Classes entity) {
        if (entity.getIndexes() == null) {
            return false;
        }
        entity.setIndexBottom(entity.getIndexes());
        return super.save(entity);
    }
}
