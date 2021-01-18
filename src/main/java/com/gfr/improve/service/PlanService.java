package com.gfr.improve.service;

import com.gfr.improve.entity.Plan;

import java.util.List;

/**
 * (Plan)表服务接口
 *
 * @author makejava
 * @since 2021-01-18 13:48:10
 */
public interface PlanService {

    /**
     * 通过ID查询单条数据
     *
     * @param palnId 主键
     * @return 实例对象
     */
    Plan queryById(String palnId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Plan> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param plan 实例对象
     * @return 实例对象
     */
    Plan insert(Plan plan);

    /**
     * 修改数据
     *
     * @param plan 实例对象
     * @return 实例对象
     */
    Plan update(Plan plan);

    /**
     * 通过主键删除数据
     *
     * @param palnId 主键
     * @return 是否成功
     */
    boolean deleteById(String palnId);

}