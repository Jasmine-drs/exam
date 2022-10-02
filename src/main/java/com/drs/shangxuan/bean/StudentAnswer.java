package com.drs.shangxuan.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Jasmine-drs
 * @date 2022/9/13 9:13
 */
@Data
@Component
public class StudentAnswer {
    public Integer id;
    public Integer examId;
    public Integer sequence;//  答案顺序
    public Integer questionId;
    public Integer type;//      题目类型
    public String answer;//     学生提交的答案
    public String nickName;//   学生名字

    /*设置字段自动填充内容*/
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime creatTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
