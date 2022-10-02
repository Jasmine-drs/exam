package com.drs.shangxuan.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.drs.shangxuan.bean.Judgment;
import com.drs.shangxuan.mapper.JudgmentMapper;
import com.drs.shangxuan.service.JudgmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/9/4 9:44
 */
@Service
@Slf4j
public class JudgmentServiceImp extends ServiceImpl<JudgmentMapper, Judgment> implements JudgmentService {

    JudgmentMapper judgmentMapper;

    public JudgmentServiceImp(JudgmentMapper judgmentMapper) {
        this.judgmentMapper = judgmentMapper;
    }

    @Override
    public List<Judgment> selectAll() {
        List<Judgment> judgments = judgmentMapper.selectByMap(null);
        if (judgments == null) {
            log.error("judgments is null");
            return null;
        }
        return judgments;
    }

    @Override
    public Boolean deleteById(String id) {
        Judgment judgment = judgmentMapper.selectById(Integer.parseInt(id));
        if (judgment == null) {
            log.error("judgment is null");
            return false;
        }
        if (judgment.getStatus() == 1) {
            judgment.setStatus(0);
        } else {
            judgment.setStatus(1);
        }
        int i = judgmentMapper.updateById(judgment);
        return i == 1;
    }

    @Override
    public Judgment selectById(String id) {
        Judgment judgment = judgmentMapper.selectById(Integer.parseInt(id));
        if (judgment == null) {
            log.error("judgment is null");
            return null;
        }
        return judgment;
    }

    @Override
    public boolean save(Judgment judgment) {
        Judgment judgment1 = judgmentMapper.selectById(judgment.getId());
//        执行插入操作
        if (judgment1 == null) {
            int insert = judgmentMapper.insert(judgment);
            return insert == 1;
        }
//        没有新对象则执行更新操作
        int i = judgmentMapper.updateById(judgment);
        return i == 1;
    }
}
