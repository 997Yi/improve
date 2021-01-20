package com.gfr.improve.dao;

import com.gfr.improve.entity.Plan;
import com.gfr.improve.entity.UserPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (UserPlan)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-19 19:24:40
 */
public interface UserPlanDao {

    /**
     * 通过ID查询单条数据
     * @param userId
     * @param planId
     * @return
     */
    UserPlan queryById(@Param("userId") String userId,@Param("planId") String planId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserPlan> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param userPlan 实例对象
     * @return 对象列表
     */
    List<UserPlan> queryAll(UserPlan userPlan);

    /**
     * 获取数据量
     * @return
     */
    Integer getCount();

    /**
     * 查询条件数据
     * @param condition
     * @param offset
     * @param limit
     * @return
     */
    List<UserPlan> queryByCondition(@Param("condition") String condition,@Param("offset") Integer offset, @Param("limit")Integer limit);

    /**
     * 查询条件数据总量
     * @param condition
     * @return
     */
    Integer getLikeCount(@Param("condition") String condition);




    /**
     * 新增数据
     *
     * @param userPlan 实例对象
     * @return 影响行数
     */
    int insert(UserPlan userPlan);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserPlan> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserPlan> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserPlan> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<UserPlan> entities);




    /**
     * 修改数据
     *
     * @param userPlan 实例对象
     * @return 影响行数
     */
    int update(UserPlan userPlan);




    /**
     * 删除所有该计划(userId、 planId、 userId + planId)对应的用户-计划
     * @param userPlan
     * @return
     */
    int delete(UserPlan userPlan);

}