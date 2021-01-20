package com.gfr.improve.service;

import com.gfr.improve.entity.Plan;
import com.gfr.improve.result.ResponseData;

import java.util.List;
import java.util.Map;

/**
 * (Plan)表服务接口
 *
 * @author makejava
 * @since 2021-01-19 10:12:16
 */
public interface PlanService {

    /**
     * 通过ID查询单条数据
     *
     * @param planId 主键
     * @return 实例对象
     */
    Plan queryById(String planId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    ResponseData queryAllByLimit(Integer offset, Integer limit);

    /**
     * 通过条件查询
     * @param condition
     * @return
     */
    ResponseData queryByConditions(String condition, Integer offset, Integer limit);

    /**
     * 查询所有带有课程名称的计划
     * @return
     */
    Map<Plan, String> queryAllPlanWithName();




    /**
     * 新增数据
     *
     * @param plan 实例对象
     * @return 实例对象
     */
    Boolean insert(Plan plan);




    /**
     * 修改数据
     *
     * @param plan 实例对象
     * @return 成功与否
     */
    Boolean update(Plan plan);





    /**
     * 通过主键删除数据 删除数据时应该同时删除user_plan映射
     *
     * @param planId 主键
     * @return 是否成功
     */
    boolean deleteById(String planId);

    /**
     * 通过主键删除数据 多个
     *
     * @param planId 主键集合
     * @return 是否成功
     */
    boolean deleteById(List<String> planId);

    /**
     * 删除课程对应的计划
     * @param courseId
     * @return
     */
    boolean deleteByCourseId(String courseId);

    /**
     * 删除课程对应的计划
     * @param courseId
     * @return
     */
    boolean deleteByCourseId(List<String> courseId);
}