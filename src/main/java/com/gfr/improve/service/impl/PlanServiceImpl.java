package com.gfr.improve.service.impl;

import com.gfr.improve.dao.PlanDao;
import com.gfr.improve.entity.Plan;
import com.gfr.improve.service.PlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Plan)表服务实现类
 *
 * @author makejava
 * @since 2021-01-18 13:48:10
 */
@Service("planService")
public class PlanServiceImpl implements PlanService {
    @Resource
    private PlanDao planDao;

    /**
     * 通过ID查询单条数据
     *
     * @param palnId 主键
     * @return 实例对象
     */
    @Override
    public Plan queryById(String palnId) {
        return this.planDao.queryById(palnId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Plan> queryAllByLimit(int offset, int limit) {
        return this.planDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param plan 实例对象
     * @return 实例对象
     */
    @Override
    public Plan insert(Plan plan) {
        this.planDao.insert(plan);
        return plan;
    }

    /**
     * 修改数据
     *
     * @param plan 实例对象
     * @return 实例对象
     */
    @Override
    public Plan update(Plan plan) {
        this.planDao.update(plan);
        return this.queryById(plan.getPalnId());
    }

    /**
     * 通过主键删除数据
     *
     * @param palnId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String palnId) {
        return this.planDao.deleteById(palnId) > 0;
    }
}