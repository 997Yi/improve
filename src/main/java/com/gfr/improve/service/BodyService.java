package com.gfr.improve.service;

import com.gfr.improve.entity.Body;
import com.gfr.improve.entity.User;
import com.gfr.improve.result.ResponseData;

import java.util.List;

/**
 * (Body)表服务接口
 *
 * @author makejava
 * @since 2021-01-18 13:47:12
 */
public interface BodyService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    Body queryById(String userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    ResponseData queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param body 实例对象
     * @return 实例对象
     */
    Body insert(Body body);

    /**
     * 修改数据
     *
     * @param body 实例对象
     * @return 实例对象
     */
    Body update(Body body);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(String userId);

    /**
     * 模糊查询
     * @param value
     * @param page
     * @param limit
     * @return
     */
    ResponseData queryByLike(String value, Integer page, Integer limit);

    /**
     * 更新用户数据
     * @param body
     * @return
     */
    ResponseData updateBody(Body body);
}