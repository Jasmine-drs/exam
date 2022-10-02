package com.drs.shangxuan.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.drs.shangxuan.bean.Choice;
import com.drs.shangxuan.mapper.ChoiceMapper;
import com.drs.shangxuan.service.ChoiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/9/4 9:44
 */
@Service
@Slf4j
public class ChoiceServiceImp extends ServiceImpl<ChoiceMapper, Choice> implements ChoiceService {

    ChoiceMapper choiceMapper;

    public ChoiceServiceImp(ChoiceMapper choiceMapper) {
        this.choiceMapper = choiceMapper;
    }

    @Override
    public List<Choice> selectAll() {
        List<Choice> choices = choiceMapper.selectByMap(null);
        if (choices == null) {
            log.error("choices is null");
            return null;
        }
        return choices;
    }

    @Override
    public Boolean deleteById(String id) {
        Choice choice = choiceMapper.selectById(Integer.parseInt(id));
        if (choice == null) {
            log.error("choice is null");
            return false;
        }
        if (choice.getStatus() == 1) {
            choice.setStatus(0);
        } else {
            choice.setStatus(1);
        }
        int i = choiceMapper.updateById(choice);
        return i == 1;
    }

    @Override
    public Choice selectById(String id) {
        Choice choice = choiceMapper.selectById(Integer.parseInt(id));
        if (choice == null) {
            log.error("choice is null");
            return null;
        }
        return choice;
    }

    public boolean save(Choice choice) {
        Choice choice1 = choiceMapper.selectById(choice.getId());
//        执行插入操作
        if (choice1 == null) {
            int insert = choiceMapper.insert(choice);
            return insert == 1;
        }
//        没有新对象则执行更新操作
        int i = choiceMapper.updateById(choice);
        return i == 1;
    }
}
