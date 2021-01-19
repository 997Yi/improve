package com.gfr.improve.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (Plan)实体类
 *
 * @author makejava
 * @since 2021-01-19 10:12:14
 */
public class Plan implements Serializable {
    private static final long serialVersionUID = -96083932054884325L;
    /**
     * 计划id
     */
    private String planId;
    /**
     * 开始时间
     */
    private Date planStart;
    /**
     * 结束时间
     */
    private Date planEnd;
    /**
     * 计划关联的课程id
     */
    private String courseId;


    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT-6")
    public Date getPlanStart() {
        return planStart;
    }

    public void setPlanStart(Date planStart) {
        this.planStart = planStart;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT-6")
    public Date getPlanEnd() {
        return planEnd;
    }

    public void setPlanEnd(Date planEnd) {
        this.planEnd = planEnd;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

}