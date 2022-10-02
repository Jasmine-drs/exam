package com.drs.shangxuan.controller;

import com.drs.shangxuan.bean.Solution;
import com.drs.shangxuan.common.R;
import com.drs.shangxuan.service.imp.SolutionServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 解答题
 *
 * @author Jasmine-drs
 * @date 2022/9/4 9:40
 */
@RestController
@RequestMapping("/solutions")
public class SolutionController {

    SolutionServiceImp solutionServiceImp;

    public SolutionController(SolutionServiceImp serviceImp) {
        this.solutionServiceImp = serviceImp;
    }

    @GetMapping
    public R<List<Solution>> selectAll() {
        List<Solution> solutions = solutionServiceImp.selectAll();
        if (solutions == null) {
            return R.err("失败");
        }
        return R.success(solutions);
    }

    @GetMapping("/{id}")
    public R<Solution> selectById(@PathVariable String id) {
        Solution solution = solutionServiceImp.selectById(id);
        if (solution == null) {
            return R.err("失败");
        }
        return R.success(solution);
    }

    @DeleteMapping("/{id}")
    public R<String> deleteById(@PathVariable String id) {
        Boolean aBoolean = solutionServiceImp.deleteById(id);
        if (aBoolean) {
            return R.success("修改成功");
        }
        return R.err("修改失败");
    }

    @PostMapping
    public R<String> sava(@RequestBody Solution solution) {
        System.out.println("solution = " + solution);
        boolean save = solutionServiceImp.save(solution);
        if (save) {
            return R.success("成功");
        }
        return R.err("失败");
    }
}
