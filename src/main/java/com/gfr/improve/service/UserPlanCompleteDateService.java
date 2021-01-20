package com.gfr.improve.service;

import com.gfr.improve.entity.UserPlanCompleteDate;

public interface UserPlanCompleteDateService {

    int insert(UserPlanCompleteDate userPlanCompleteDate);

    int delete(String userId);
}
