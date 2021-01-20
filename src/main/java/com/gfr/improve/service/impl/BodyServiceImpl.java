package com.gfr.improve.service.impl;

import com.gfr.improve.dao.BodyDao;
import com.gfr.improve.entity.Body;
import com.gfr.improve.entity.User;
import com.gfr.improve.result.ResponseCode;
import com.gfr.improve.result.ResponseData;
import com.gfr.improve.service.BodyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
    public ResponseData queryAllByLimit(int offset, int limit) {

        int num = this.bodyDao.queryCount();
        List<Body> list = this.bodyDao.queryAllByLimit(offset, limit);
        return new ResponseData("0", "操作成功", list, num);
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

    @Override
    public ResponseData queryByLike(String value, Integer page, Integer limit) {
        if (page != null && limit != null) {
            page = (page - 1) * limit;
        } else {
            page = 0;
            limit = 10;
        }
        Integer i = bodyDao.countByLike(value);
        List<Body> pics = bodyDao.queryByLike(value, page, limit);
        return new ResponseData("0", "操作成功", pics, i);
    }

    @Transactional
    @Override
    public ResponseData updateBody(Body body) {
        try{
            String field = body.getField();
            String value = body.getValue();
            //判断field的类型
            if(field != null && field != "" && value != null){
                switch (field){
                    case "height":
                        body.setHeight(value);
                        break;
                    case "weight":
                        body.setWeight(value);
                        break;
                    case "chestCircumference":
                        body.setChestCircumference(value);
                        break;
                    case "waistline":
                        body.setWaistline(value);
                        break;
                    case "hipline":
                        body.setHipline(value);
                        break;
                    case "bodyFatRate":
                        body.setBodyFatRate(value);
                        break;

                }

                int i = this.bodyDao.update(body);
                if(i>0){
                    return new ResponseData(ResponseCode.SUCCESS);
                }else{
                    return new ResponseData(ResponseCode.FAILED);
                }
            }else{
                int i = this.bodyDao.update(body);
                if(i>0){
                    return new ResponseData(ResponseCode.SUCCESS);
                }else{
                    return new ResponseData(ResponseCode.FAILED);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ResponseData(ResponseCode.FAILED);
        }
    }

    @Override
    @Transactional
    public ResponseData deleteBodys(List<String> userIdList) {
        try {
            int rows = 0;
            for (String userId : userIdList){
                rows += bodyDao.deleteById(userId);
            }
            if (rows == userIdList.size()) {
                return new ResponseData(ResponseCode.SUCCESS);
            }
            return new ResponseData(ResponseCode.FAILED);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ResponseData(ResponseCode.FAILED);
        }

    }

    @Override
    public ResponseData addBody(Body body) {
        return new ResponseData(ResponseCode.SUCCESS, bodyDao.insert(body));
    }
}