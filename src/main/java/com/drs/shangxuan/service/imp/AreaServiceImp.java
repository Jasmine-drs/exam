package com.drs.shangxuan.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.drs.shangxuan.bean.Area;
import com.drs.shangxuan.bean.School;
import com.drs.shangxuan.mapper.AreaMapper;
import com.drs.shangxuan.mapper.SchoolMapper;
import com.drs.shangxuan.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/8/26 9:30
 */
@Service
@Slf4j
public class AreaServiceImp extends ServiceImpl<AreaMapper, Area> implements AreaService {

    AreaMapper areaMapper;
    SchoolMapper schoolMapper;

    public AreaServiceImp(AreaMapper areaMapper, SchoolMapper schoolMapper) {
        this.areaMapper = areaMapper;
        this.schoolMapper = schoolMapper;
    }

    @Override
    public List<School> selectById(String id) {
//        转数字
        int i = Integer.parseInt(id);
//        构造查询条件
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", i);
        List<Area> areas = areaMapper.selectByMap(map);
//        判断是否存在
        if (areas == null) {
            log.error("areas is all null");
            return null;
        }
        Area area = areas.get(0);
        if (area == null) {
            log.error("Area is null");
            return null;
        }
        /*判断是否被删除*/
        if (area.getStatus() == 0) {
            log.error("Area is abolished");
            return null;
        }
        /*获取下级组织的索引*/
        Integer indexes = area.getIndexes();
        /*查找下级组织并返回*/
        map.remove("id");
        map.put("indexes", indexes);
        System.out.println(map);
        List<School> schools = schoolMapper.selectByMap(map);
        if (schools == null) {
            log.error("School is null");
            return null;
        }
        return schools;
    }

    @Override
    public List<Area> selectAll(String value) {
        List<Area> areas = areaMapper.selectByMap(null);
        if (areas.size() == 0) {
            log.error("area is all null");
            return null;
        }
        return areas;
    }

    @Override
    public Boolean selectAreaById(String id) {
        int i = Integer.parseInt(id);
        Area area = areaMapper.selectById(i);
        Integer status = area.getStatus();
        if (status == 1) {
            log.error("area is null -- update failed");
            area.setStatus(0);
        } else {
            area.setStatus(1);
        }
        int i1 = areaMapper.updateById(area);
        return i1 != 0;
    }

    @Override
    public boolean save(Area area) {
        Integer indexBottom = area.getIndexBottom();
        if (indexBottom == null) {
            return false;
        }
        area.setIndexes(indexBottom);
        return super.save(area);
    }
}
