package com.drs.shangxuan.common;

import lombok.Data;

/**
 * 返回结果的通用类
 *
 * @author Jasmine-drs
 * @date 2022/8/5 18:02
 */
@Data
public class R<T> {
    private String msg;
    /* 1 成功 0 失败*/
    private int code;
    private T data;

    public static <T> R<T> success(T object) {
        R<T> tr = new R<>();
        tr.code = 1;
        tr.data = object;
        return tr;
    }

    public static <T> R<T> err(String msg) {
        R<T> tr = new R<>();
        tr.code = 0;
        tr.msg = msg;
        return tr;
    }
}
