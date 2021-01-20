package com.gfr.improve.dao;

import com.gfr.improve.entity.UserPlanCompleteDate;

public interface UserPlanCompleteDateDao {

    int insert(UserPlanCompleteDate userPlanCompleteDate);

    int delete(String userId);
}
