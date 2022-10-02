package com.drs.shangxuan.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Jasmine-drs
 * @date 2022/9/13 22:41
 */
@Data
@Component
public class Result {
    public Integer id;
    public Integer examId;
    public String nickName;
    public Integer achievement;
    /*设置字段自动填充内容*/
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime creatTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
