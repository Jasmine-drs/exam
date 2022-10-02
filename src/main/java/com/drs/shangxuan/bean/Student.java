package com.drs.shangxuan.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Jasmine-drs
 * @date 2022/8/18 17:49
 */
@Data
@Component
public class Student {
    public Integer id;
    public String name;//   真实姓名
    public String nickName;//   昵称
    public String sex;//   性别
    public String school;// 学校
    public String classes;//    班级
    public String avatarUrl;//  头像地址

    /*设置字段自动填充内容*/
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime creatTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
