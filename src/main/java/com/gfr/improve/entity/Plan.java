package com.gfr.improve.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Plan)实体类
 *
 * @author makejava
 * @since 2021-01-18 13:48:09
 */
public class Plan implements Serializable {
    private static final long serialVersionUID = -72308629059217445L;
    /**
     * 计划id
     */
    private String palnId;
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


    public String getPalnId() {
        return palnId;
    }

    public void setPalnId(String palnId) {
        this.palnId = palnId;
    }

    public Date getPlanStart() {
        return planStart;
    }

    public void setPlanStart(Date planStart) {
        this.planStart = planStart;
    }

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