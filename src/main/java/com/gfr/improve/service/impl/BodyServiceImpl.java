package com.gfr.improve.service.impl;

import com.gfr.improve.dao.BodyDao;
import com.gfr.improve.entity.Body;
import com.gfr.improve.service.BodyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Body)表服务实现类
 *
 * @author makejava
 * @since 2021-01-18 13:47:15
 */
@Service("bodyService")
public class BodyServiceImpl implements BodyService {
    @Resource
    private BodyDao bodyDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public Body queryById(String userId) {
        return this.bodyDao.queryById(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Body> queryAllByLimit(int offset, int limit) {
        return this.bodyDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param body 实例对象
     * @return 实例对象
     */
    @Override
    public Body insert(Body body) {
        this.bodyDao.insert(body);
        return body;
    }

    /**
     * 修改数据
     *
     * @param body 实例对象
     * @return 实例对象
     */
    @Override
    public Body update(Body body) {
        this.bodyDao.update(body);
        return this.queryById(body.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String userId) {
        return this.bodyDao.deleteById(userId) > 0;
    }
}