package com.drs.shangxuan.controller;

import com.drs.shangxuan.bean.Result;
import com.drs.shangxuan.common.R;
import com.drs.shangxuan.service.imp.ResultServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/9/13 22:39
 */
@RestController
@RequestMapping("/results")
public class ResultController {

    ResultServiceImp resultServiceImp;

    public ResultController(ResultServiceImp resultServiceImp) {
        this.resultServiceImp = resultServiceImp;
    }

    @PostMapping
    public R<String> save(@RequestBody Result result) {
        System.out.println("result = " + result);
        boolean save = resultServiceImp.save(result);
        if (save) {
            return R.success("成功");
        }
        return R.err("成绩添加失败");
    }

    @GetMapping("/{nickName}")
    public R<List<Result>> selectByNickName(@PathVariable String nickName) {
        System.out.println("nickName = " + nickName);
        List<Result> results = resultServiceImp.selectByNickName(nickName);
        return R.success(results);
    }
}
