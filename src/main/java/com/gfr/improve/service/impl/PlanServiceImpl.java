package com.gfr.improve.service.impl;

import com.gfr.improve.dao.PlanDao;
import com.gfr.improve.entity.Plan;
import com.gfr.improve.result.ResponseCode;
import com.gfr.improve.result.ResponseData;
import com.gfr.improve.service.PlanService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Plan)表服务实现类
 *
 * @author makejava
 * @since 2021-01-19 10:12:16
 */
@Service("planService")
public class PlanServiceImpl implements PlanService {
    @Resource
    private PlanDao planDao;

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
        try{
            if(planDao.insert(plan) > 0){
                return true;
            }else{
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    /**
     * 修改数据
     *
     * @param plan 实例对象
     * @return 是否成功
     */
    @Override
    @Transactional
    public Boolean update(Plan plan) {
        try{
            if(planDao.update(plan) > 0){
                return true;
            }else{
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param planId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String planId) {
        return this.planDao.deleteById(planId) > 0;
    }


    /**
     * 通过主键删除数据
     *
     * @param planId 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public boolean deleteById(List<String> planId) {
        try{
            for(String id : planId){
                if(planDao.deleteById(id) == 0){
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return false;
                }
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
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
}