package com.gfr.improve.service;

import com.gfr.improve.entity.UserPlanCompleteDate;
import com.gfr.improve.result.ResponseData;

public interface UserPlanCompleteDateService {

    int insert(UserPlanCompleteDate userPlanCompleteDate);

    int delete(String userId);

    ResponseData queryDate(String userId, Integer year, Integer month);
}
