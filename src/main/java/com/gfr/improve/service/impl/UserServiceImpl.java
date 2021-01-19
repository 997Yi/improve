package com.gfr.improve.service.impl;

import com.gfr.improve.dao.UserDao;
import com.gfr.improve.entity.User;
import com.gfr.improve.result.ResponseData;
import com.gfr.improve.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2021-01-18 13:48:29
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public User queryById(String userId) {
        return this.userDao.queryById(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String userId) {
        return this.userDao.deleteById(userId) > 0;
    }

    /**
     * 查询用户数量
     * @return 用户数量
     */
    public int queryUserNum(){
        return this.userDao.queryUserNum();
    }


    /**
     * 模糊查询
     * @param value 模糊查询用到的字符串
     * @param page
     * @param limit
     * @return
     */
    @Override
    public ResponseData queryByLike(String value, Integer page, Integer limit) {
        if(page != null && limit != null){
            page = (page-1)*limit;
        }else{
            page = 0;
            limit = 10;
        }
        Integer i =  userDao.countByLike(value);
        List<User> pics =  userDao.queryByLike(value,page, limit);
        return new ResponseData("0","操作成功",pics,i);
    }
}