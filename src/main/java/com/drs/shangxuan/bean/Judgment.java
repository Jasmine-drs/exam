package com.drs.shangxuan.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 判断题
 *
 * @author Jasmine-drs
 * @date 2022/9/4 9:35
 */
@Data
@Component
public class Judgment extends Question {
    public Integer id;
    public String name;
    public String answer;// 答案
    public String optionA;//    四个选项
    public String optionB;
    public Integer fraction;//   分数
    public Integer status;// 状态
    public String operator;//   操作员
    public Integer type;//  题目类型
    /*设置字段自动填充内容*/
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime creatTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
