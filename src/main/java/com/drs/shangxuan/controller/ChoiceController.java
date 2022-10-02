package com.drs.shangxuan.controller;

import com.drs.shangxuan.bean.Choice;
import com.drs.shangxuan.common.R;
import com.drs.shangxuan.service.imp.ChoiceServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 选择题
 *
 * @author Jasmine-drs
 * @date 2022/9/4 9:38
 */
@RestController
@RequestMapping("/choices")
public class ChoiceController {

    ChoiceServiceImp choiceServiceImp;

    public ChoiceController(ChoiceServiceImp choiceServiceImp) {
        this.choiceServiceImp = choiceServiceImp;
    }

    @GetMapping
    public R<List<Choice>> selectAll() {
        List<Choice> choices = choiceServiceImp.selectAll();
        if (choices == null) {
            return R.err("失败");
        }
        return R.success(choices);
    }

    @GetMapping("/{id}")
    public R<Choice> selectById(@PathVariable String id) {
        Choice choice = choiceServiceImp.selectById(id);
        if (choice == null) {
            return R.err("失败");
        }
        return R.success(choice);
    }

    @DeleteMapping("/{id}")
    public R<String> deleteById(@PathVariable String id) {
        System.out.println("id = " + id);
        Boolean aBoolean = choiceServiceImp.deleteById(id);
        if (aBoolean) {
            return R.success("修改成功");
        }
        return R.err("修改失败");
    }

    @PostMapping
    public R<String> sava(@RequestBody Choice choice) {
        System.out.println("choice = " + choice);
        boolean save = choiceServiceImp.save(choice);
        if (save) {
            return R.success("成功");
        }
        return R.err("失败");
    }
}
