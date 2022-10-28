package com.drs.shangxuan.tool;

import com.drs.shangxuan.common.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * springMVC的异常处理器
 *
 * @author Jasmine-drs
 * @date 2022/10/28 19:24
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {

    //    拦截所有异常,处理后返回统一格式
    @ExceptionHandler
    public R<String> doException(Exception e) {
//        记录日志
//        通知各级
//        处理异常
        e.printStackTrace();
        return R.err("服务器异常，请稍后再试！");
    }
}
