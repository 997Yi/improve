package com.gfr.improve.dao;

import com.gfr.improve.entity.Body;
import com.gfr.improve.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Body)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-18 13:47:08
 */
public interface BodyDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    Body queryById(String userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Body> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param body 实例对象
     * @return 对象列表
     */
    List<Body> queryAll(Body body);

    /**
     * 新增数据
     *
     * @param body 实例对象
     * @return 影响行数
     */
    int insert(Body body);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Body> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Body> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Body> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Body> entities);

    /**
     * 修改数据
     *
     * @param body 实例对象
     * @return 影响行数
     */
    int update(Body body);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(String userId);

    /**
     * 查询数量
     * @return
     */
    int queryCount();

    /**
     * 模糊查询
     * @param value
     * @param page
     * @param limit
     * @return
     */
    List<Body> queryByLike(String value, Integer page, Integer limit);

    /**
     * 模糊查询的结果数量
     * @param value
     * @return
     */
    int countByLike(String value);

    /**
     * 更新body
     * @param body
     * @return
     */
    int updateBody(Body body);
}