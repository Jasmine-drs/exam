package com.drs.shangxuan.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Jasmine-drs
 * @date 2022/5/21 14:59
 */
@Component // 把处理器添加到IOC容器中
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    /*插入时对应的填充*/
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        /*每写一个自动填充都要在 Handler 里面设置*/
        this.strictInsertFill(metaObject, "creatTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }

    /*更新时对应的填充*/
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");

        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }
}
