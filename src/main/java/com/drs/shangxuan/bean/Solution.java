package com.drs.shangxuan.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 解答题
 *
 * @author Jasmine-drs
 * @date 2022/9/4 9:36
 */
@Data
@Component
public class Solution extends Question {
    public Integer id;
    public String name;
    public String answer;// 答案
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
