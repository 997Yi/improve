package com.gfr.improve.dao;

import com.gfr.improve.entity.UserPlanCompleteDate;

import java.util.List;

public interface UserPlanCompleteDateDao {

    int insert(UserPlanCompleteDate userPlanCompleteDate);

    int delete(String userId);

    List<UserPlanCompleteDate> queryDate(String userId);

    List<UserPlanCompleteDate> queryByLike(String userId, String year, String month);
}
