package com.drs.shangxuan.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.drs.shangxuan.bean.Solution;
import com.drs.shangxuan.mapper.SolutionMapper;
import com.drs.shangxuan.service.SolutionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/9/4 9:44
 */
@Service
@Slf4j
public class SolutionServiceImp extends ServiceImpl<SolutionMapper, Solution> implements SolutionService {

    SolutionMapper solutionMapper;

    public SolutionServiceImp(SolutionMapper solutionMapper) {
        this.solutionMapper = solutionMapper;
    }

    @Override
    public List<Solution> selectAll() {
        List<Solution> solutions = solutionMapper.selectByMap(null);
        if (solutions == null) {
            log.error("solutions is null");
            return null;
        }
        return solutions;
    }

    @Override
    public Boolean deleteById(String id) {
        Solution solution = solutionMapper.selectById(Integer.parseInt(id));
        if (solution == null) {
            log.error("solution is null");
            return false;
        }
        if (solution.getStatus() == 1) {
            solution.setStatus(0);
        } else {
            solution.setStatus(1);
        }
        int i = solutionMapper.updateById(solution);
        return i == 1;
    }

    @Override
    public boolean save(Solution solution) {
        boolean result;
        Solution solution1 = solutionMapper.selectById(solution.getId());
//        执行插入操作
        if (solution1 == null) {
            int insert = solutionMapper.insert(solution);
            result = insert == 1;
        } else {//        没有新对象则执行更新操作
            int i = solutionMapper.updateById(solution);
            result = i == 1;
        }
        return result;
    }

    @Override
    public Solution selectById(String id) {
        Solution solution = solutionMapper.selectById(Integer.parseInt(id));
        if (solution == null) {
            log.error("solution is null");
            return null;
        }
        return solution;
    }
}
