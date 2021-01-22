package com.gfr.improve.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserPlanCompleteDate {

    private String userId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planCompleteDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public Date getPlanCompleteDate() {
        return planCompleteDate;
    }

    public void setPlanCompleteDate(Date planCompleteDate) {
        this.planCompleteDate = planCompleteDate;
    }


}
