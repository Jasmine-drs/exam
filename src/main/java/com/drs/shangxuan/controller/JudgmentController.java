package com.drs.shangxuan.controller;

import com.drs.shangxuan.bean.Judgment;
import com.drs.shangxuan.common.R;
import com.drs.shangxuan.service.imp.JudgmentServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 判断题
 *
 * @author Jasmine-drs
 * @date 2022/9/4 9:39
 */
@RestController
@RequestMapping("/judgments")
public class JudgmentController {

    JudgmentServiceImp judgmentServiceImp;

    public JudgmentController(JudgmentServiceImp judgmentServiceImp) {
        this.judgmentServiceImp = judgmentServiceImp;
    }

    @GetMapping
    public R<List<Judgment>> selectAll() {
        List<Judgment> judgments = judgmentServiceImp.selectAll();
        if (judgments == null) {
            return R.err("失败");
        }
        return R.success(judgments);
    }

    @GetMapping("/{id}")
    public R<Judgment> selectById(@PathVariable String id) {
        Judgment judgment = judgmentServiceImp.selectById(id);
        if (judgment == null) {
            return R.err("失败");
        }
        return R.success(judgment);
    }

    @DeleteMapping("/{id}")
    public R<String> deleteById(@PathVariable String id) {
        Boolean aBoolean = judgmentServiceImp.deleteById(id);
        if (aBoolean) {
            return R.success("修改成功");
        }
        return R.err("修改失败");
    }

    @PostMapping
    public R<String> sava(@RequestBody Judgment judgment) {
        System.out.println("judgment = " + judgment);
        boolean save = judgmentServiceImp.save(judgment);
        if (save) {
            return R.success("成功");
        }
        return R.err("失败");
    }
}
