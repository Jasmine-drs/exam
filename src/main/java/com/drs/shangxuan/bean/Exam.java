package com.drs.shangxuan.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 试卷基本信息
 *
 * @author Jasmine-drs
 * @date 2022/9/7 9:09
 */
@Data
@Component
public class Exam {
    public Integer id;
    //    试卷名
    public String name;
    //    场次
    public String batch;
    //    试卷说明
    public String info;

    //    开始和结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")// 控制入参，序列化前端传递过来的数据
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")// 控制出参，序列化传向前端的数据
    public LocalDateTime startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime endTime;

    //    试卷总分
    public Integer point;
    //    组卷人
    public String operator;
    //    四级组织
    public String primaryOrganization;
    public String secondaryOrganization;
    public String tertiaryOrganization;
    public String fourOrganization;

    /*设置字段自动填充内容*/
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime creatTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
