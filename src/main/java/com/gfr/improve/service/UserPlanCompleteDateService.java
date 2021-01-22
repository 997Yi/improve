package com.gfr.improve.service;

import com.gfr.improve.entity.UserPlanCompleteDate;
import com.gfr.improve.result.ResponseData;

public interface UserPlanCompleteDateService {

    ResponseData insert(UserPlanCompleteDate userPlanCompleteDate);

    ResponseData delete(String userId);

    ResponseData queryDate(String userId, Integer year, Integer month);

    ResponseData isAllPlanComplete(UserPlanCompleteDate userPlanCompleteDate);
}
