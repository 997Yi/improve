package com.gfr.improve.service.impl;

import com.gfr.improve.dao.UserPlanDao;
import com.gfr.improve.entity.Plan;
import com.gfr.improve.entity.User;
import com.gfr.improve.entity.UserPlan;
import com.gfr.improve.result.ResponseCode;
import com.gfr.improve.result.ResponseData;
import com.gfr.improve.service.UserPlanService;
import com.gfr.improve.util.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (UserPlan)表服务实现类
 *
 * @author makejava
 * @since 2021-01-19 19:24:42
 */
@Service("userPlanService")
@Transactional(rollbackFor = Exception.class)
public class UserPlanServiceImpl implements UserPlanService {
    @Resource
    private UserPlanDao userPlanDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @param planId 主键
     * @return 实例对象
     */
    @Override
    public UserPlan queryById(String userId, String planId) {
        return this.userPlanDao.queryById(userId, planId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public ResponseData queryAllByLimit(Integer offset, Integer limit) {
        if(offset == null || limit == null){
            //存在空则给默认值
            offset = 0;
            limit = 10;
        }else{
            offset = (offset - 1) * limit;
        }

        return new ResponseData("0", "SUCCESS", userPlanDao.queryAllByLimit(offset, limit), userPlanDao.getCount());
    }

    /**
     * 新增数据
     *
     * @param userPlan 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean insert(UserPlan userPlan) {
        //没有对用户设置上次打卡时间，则默认填入昨天
        if(userPlan.getChecktime() == null){
            userPlan.setChecktime(DateUtil.addDay(DateUtil.getStart(), -1));
        }

        if(userPlanDao.insert(userPlan) > 0){
            return true;
        }
        return false;
    }

    /**
     * 修改数据
     *
     * @param userPlan 实例对象
     * @return 是否成功
     */
    @Override
    @Transactional
    public Boolean update(UserPlan userPlan) {
        if(userPlanDao.update(userPlan) > 0){
            return true;
        }
        return false;
    }

    /**
     * 通过主键删除数据
     *
     * @param userPlan
     * @return 是否成功
     */
    @Override
    public boolean delete(UserPlan userPlan) {
        return this.userPlanDao.delete(userPlan) > 0;
    }

    /**
     * 删除列表中的所有user_plan
     * @param userPlanList
     * @return
     */
    @Override
    public boolean delete(List<UserPlan> userPlanList) {
        //对列表进行遍历， 对每一个进行删除
        for(UserPlan userPlan : userPlanList){
            if(userPlanDao.delete(userPlan) == 0){
                return false;
            }
        }
        return true;
    }


    /**
     * 通过条件查询
     * @param condition
     * @param offset
     * @param limit
     * @return
     */
    @Override
    public ResponseData queryByConditions(String condition, Integer offset, Integer limit) {
        if(offset == null || limit == null){
            offset = 1;
            limit = 10;
        }else{
            offset = (offset - 1) * limit;
        }

        List<UserPlan> userPlanList = userPlanDao.queryByCondition(condition, offset, limit);
        if(userPlanList != null){
            return new ResponseData("0", "操作成功", userPlanList, userPlanDao.getLikeCount(condition));
        }
        return new ResponseData(ResponseCode.FAILED);
    }


    /**
     * 删除与用户有关的user-plan
     * @param userId
     * @return
     */
    @Override
    public boolean deleteByUserId(String userId){
        List<String> list = new ArrayList<>(1);
        list.add(userId);

        return deleteByUserId(list);
    }


    /**
     * 删除与用户有关的user-plan
     * @param userId
     * @return
     */
    @Override
    public boolean deleteByUserId(List<String> userId){
        UserPlan userPlan = new UserPlan();
        for(String id : userId){
            userPlan.setUserId(id);

            if(userPlanDao.delete(userPlan) == 0){
                return false;
            }
        }
        return true;
    }


    /**
     * 查询所有该用户的user-plan
     * @param userId
     * @return
     */
    @Override
    public List<UserPlan> queryByUserId(String userId){
        UserPlan userPlan = new UserPlan();
        userPlan.setUserId(userId);

        return userPlanDao.queryAll(userPlan);
    }

}