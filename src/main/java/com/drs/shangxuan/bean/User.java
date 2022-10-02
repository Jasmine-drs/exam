package com.drs.shangxuan.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Jasmine-drs
 * @date 2022/8/4 17:30
 */
@Data
@Component
public class User {
    private Integer id;
    private String name;
    private String userName;
    private String password;
    private String sex;
    private Integer age;
    private String phone;
    private Integer type;
    private Integer status;

    /*设置字段自动填充内容*/
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime creatTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
