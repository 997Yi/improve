package com.gfr.improve.service.impl;

import com.gfr.improve.dao.CourseDao;
import com.gfr.improve.dao.PlanDao;
import com.gfr.improve.dao.UserPlanDao;
import com.gfr.improve.entity.Plan;
import com.gfr.improve.entity.UserPlan;
import com.gfr.improve.result.ResponseCode;
import com.gfr.improve.result.ResponseData;
import com.gfr.improve.service.PlanService;
import com.gfr.improve.service.UserPlanService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.print.attribute.HashAttributeSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Plan)表服务实现类
 *
 * @author makejava
 * @since 2021-01-19 10:12:16
 */
@Service("planService")
@Transactional(rollbackFor = Exception.class)
public class PlanServiceImpl implements PlanService {
    @Resource
    private PlanDao planDao;

    @Resource
    private CourseDao courseDao;

    @Resource
    private UserPlanDao userPlanDao;

    /**
     * 通过ID查询单条数据
     *
     * @param planId 主键
     * @return 实例对象
     */
    @Override
    public Plan queryById(String planId) {
        return this.planDao.queryById(planId);
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

        return new ResponseData("0", "SUCCESS", planDao.queryAllByLimit(offset, limit), planDao.getCount());
    }

    /**
     * 新增数据
     *
     * @param plan 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean insert(Plan plan) {
        if(planDao.insert(plan) > 0){
            return true;
        }
        return false;
    }

    /**
     * 修改数据
     *
     * @param plan 实例对象
     * @return 是否成功
     */
    @Override
    public Boolean update(Plan plan) {
        if(planDao.update(plan) > 0){
            return true;
        }
        return false;
    }

    /**
     * 通过主键删除数据 删除数据时应该同时删除user_plan映射
     *
     * @param planId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String planId) {
        if(planDao.deleteById(planId) != 0){
            UserPlan userPlan = new UserPlan();
            userPlan.setPlanId(planId);

            return userPlanDao.delete(userPlan) != 0;
        }
        return false;
    }

    /**
     * 通过主键删除数据
     *
     * @param planId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(List<String> planId) {
        for(String id : planId){
            if(!deleteById(id)){
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

        List<Plan> plans = planDao.queryByCondition(condition, offset, limit);
        if(plans != null){
            return new ResponseData("0", "操作成功", plans, planDao.getLikeCount(condition));
        }
        return new ResponseData(ResponseCode.FAILED);
    }


    @Override
    public Map<Plan, String> queryAllPlanWithName() {
        List<Plan> plans = planDao.queryAll(null);
        Map<Plan, String> resMap = new HashMap();

        for(Plan plan : plans){
            resMap.put(plan, courseDao.queryById(plan.getCourseId()).getCName());
        }

        return resMap;
    }



    /**
     * 删除课程对应的计划
     * @param courseId
     * @return
     */
    @Override
    public boolean deleteByCourseId(String courseId){
        //根据courseId查询所有与课程有关的计划
        Plan condition = new Plan();
        condition.setCourseId(courseId);
        List<Plan> plans = planDao.queryAll(condition);

        //对所有计划进行删除
        for(Plan plan : plans){
            if(!deleteById(plan.getPlanId())){
                return false;
            }
        }

        return true;
    }

    /**
     * 删除课程对应的计划
     * @param courseId
     * @return
     */
    @Override
    public boolean deleteByCourseId(List<String> courseId){
        for(String id : courseId){
            if(!deleteByCourseId(id)){
                return false;
            }
        }
        return true;
    }
}