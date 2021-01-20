package com.gfr.improve.service;

import com.gfr.improve.entity.UserPlan;
import com.gfr.improve.result.ResponseData;

import java.util.List;

/**
 * (UserPlan)表服务接口
 *
 * @author makejava
 * @since 2021-01-19 19:24:41
 */
public interface UserPlanService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @param planId
     * @return 实例对象
     */
    UserPlan queryById(String userId, String planId);

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
     * @param page
     * @param limit
     * @return
     */
    ResponseData queryByConditions(String condition, Integer page, Integer limit);






    /**
     * 新增数据
     *
     * @param userPlan 实例对象
     * @return 实例对象
     */
    Boolean insert(UserPlan userPlan);






    /**
     * 修改数据
     *
     * @param userPlan 实例对象
     * @return 实例对象
     */
    Boolean update(UserPlan userPlan);






    /**
     * 通过主键删除数据
     *
     * @param userPlan
     * @return 是否成功
     */
    boolean delete(UserPlan userPlan);

    /**
     * 删除列表中的所有user_plan
     * @param userPlanList
     * @return
     */
    boolean delete(List<UserPlan> userPlanList);

    /**
     * 删除与用户有关的user-plan
     * @param userId
     * @return
     */
    boolean deleteByUserId(String userId);

    /**
     * 删除与用户有关的user-plan
     * @param userId
     * @return
     */
    boolean deleteByUserId(List<String> userId);
}