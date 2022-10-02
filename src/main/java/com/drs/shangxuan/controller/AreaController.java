package com.drs.shangxuan.controller;

import com.drs.shangxuan.bean.Area;
import com.drs.shangxuan.bean.School;
import com.drs.shangxuan.common.R;
import com.drs.shangxuan.service.imp.AreaServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/8/26 9:27
 */
@RestController
@RequestMapping("/areas")
public class AreaController {

    AreaServiceImp areaServiceImp;

    public AreaController(AreaServiceImp areaServiceImp) {
        this.areaServiceImp = areaServiceImp;
    }

    @GetMapping
    public R<List<School>> selectById(String id) {
        System.out.println("AreaController.selectById");
        System.out.println("id = " + id);
        List<School> schools = areaServiceImp.selectById(id);
        if (schools == null) {
            return R.err(null);
        }
        return R.success(schools);
    }

    @GetMapping("/{value}")
    public R<List<Area>> selectAll(@PathVariable String value) {
        if (!value.equals("all")) {
            Boolean aBoolean = areaServiceImp.selectAreaById(value);
            if (aBoolean) {
                return R.success(null);
            } else {
                return R.err("失败");
            }
        }
        List<Area> areas = areaServiceImp.selectAll(value);
        if (areas == null) {
            return R.err("查询为空");
        }
        return R.success(areas);
    }

    @PostMapping
    public R<String> save(@RequestBody Area area) {
        System.out.println("area = " + area);
        boolean save = areaServiceImp.save(area);
        if (save) {
            return R.success("成功");
        }
        return R.err("增加失败");
    }
}
