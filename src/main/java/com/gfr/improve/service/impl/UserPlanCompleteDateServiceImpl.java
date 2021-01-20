package com.gfr.improve.service.impl;

import com.gfr.improve.dao.UserDao;
import com.gfr.improve.dao.UserPlanCompleteDateDao;
import com.gfr.improve.entity.UserPlanCompleteDate;
import com.gfr.improve.service.UserPlanCompleteDateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userPlanCompleteDateService")
public class UserPlanCompleteDateServiceImpl implements UserPlanCompleteDateService {

    @Resource
    private UserPlanCompleteDateDao userPlanCompleteDateDao;

    @Override
    public int insert(UserPlanCompleteDate userPlanCompleteDate) {
        return userPlanCompleteDateDao.insert(userPlanCompleteDate);
    }

    @Override
    public int delete(String userId) {
        return userPlanCompleteDateDao.delete(userId);
    }
}
