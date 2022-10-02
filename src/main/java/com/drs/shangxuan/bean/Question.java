package com.drs.shangxuan.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author Jasmine-drs
 * @date 2022/9/12 21:09
 */
@Data
@Component
public class Question {
    public Integer id;
    public String name;
    public String answer;// 答案
    public Integer fraction;//   分数
    public Integer status;// 状态
    public String operator;//   操作员
    public Integer type;//  题目类型
}
