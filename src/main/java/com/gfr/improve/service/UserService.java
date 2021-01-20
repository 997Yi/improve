package com.gfr.improve.service;

import com.gfr.improve.entity.User;
import com.gfr.improve.result.ResponseData;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2021-01-18 13:48:29
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(String userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(String userId);

    /**
     * 查询用户数量
     * @return 用户数量
     */
    int queryUserNum();

    /**
     * 模糊查询
     * @param value 模糊查询用到的字符串
     * @param page
     * @param limit
     * @return
     */
    ResponseData queryByLike(String value, Integer page, Integer limit);

    /**
     * 更新用户数据
     * @param user
     * @return
     */
    ResponseData updateUser(User user);

    /**
     * 删除用户列表
     * @param userIdList
     * @return
     */
    ResponseData deleteUsers(List<String> userIdList);

    ResponseData addUser(User user);
}