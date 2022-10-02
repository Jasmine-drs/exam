package com.drs.shangxuan.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.drs.shangxuan.bean.Result;
import com.drs.shangxuan.mapper.ResultMapper;
import com.drs.shangxuan.service.ResultService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/9/14 13:26
 */
@Service
public class ResultServiceImp extends ServiceImpl<ResultMapper, Result> implements ResultService {

    ResultMapper resultMapper;

    public ResultServiceImp(ResultMapper resultMapper) {
        this.resultMapper = resultMapper;
    }

    public boolean save(Result result) {
        QueryWrapper<Result> wrapper = new QueryWrapper<>();
        wrapper.eq("exam_id", result.examId)
                .eq("nick_name", result.nickName);
        Result result1 = resultMapper.selectOne(wrapper);
//        如果为空，则添加
        if (result1 == null) {
            int insert = resultMapper.insert(result);
            return insert == 1;
        }
//        否则更新数据
        result1.setAchievement(result.achievement);
        int i = resultMapper.updateById(result1);
        return i == 1;
    }

    @Override
    public List<Result> selectByNickName(String nickName) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("nick_name", nickName);
        return resultMapper.selectByMap(map);
    }
}
