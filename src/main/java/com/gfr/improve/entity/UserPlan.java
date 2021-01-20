package com.gfr.improve.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (UserPlan)实体类
 *
 * @author makejava
 * @since 2021-01-19 19:24:39
 */
public class UserPlan implements Serializable {
    private static final long serialVersionUID = -47670070746322796L;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 计划id
     */
    private String planId;
    /**
     * 最后一次打卡时间
     */
    private Date checktime;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

}