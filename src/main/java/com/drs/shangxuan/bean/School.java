package com.drs.shangxuan.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Jasmine-drs
 * @date 2022/8/25 16:14
 */
@Data
@Component
public class School {

    public Integer id;
    public String name;
    public Integer indexes;
    public Integer indexBottom;
    public Integer status;

    /*设置字段自动填充内容*/
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime creatTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
