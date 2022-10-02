package com.drs.shangxuan.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 试卷题目，通过examId与试卷基本信息关联，组合成一张试卷
 *
 * @author Jasmine-drs
 * @date 2022/9/7 9:15
 */
@Data
@Component
public class ExamPaper {
    public Integer id;
    //    对应exam表的id
    public Integer examId;
    //    题目顺序
    public Integer sequence;
    //    题目id
    public Integer questionId;
    //    每道题的题目类型
    public Integer type;
    //    选题人员
    public String operator;

    /*设置字段自动填充内容*/
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime creatTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
