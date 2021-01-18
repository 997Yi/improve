package com.gfr.improve.entity;

import java.io.Serializable;

/**
 * (Course)实体类
 *
 * @author makejava
 * @since 2021-01-18 13:47:46
 */
public class Course implements Serializable {
    private static final long serialVersionUID = 567793102759672778L;

    private String cId;

    private String cName;

    private String cDescribe;

    private String cVurl;

    private String cPurl;

    private Integer cTime;


    public String getCId() {
        return cId;
    }

    public void setCId(String cId) {
        this.cId = cId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getCDescribe() {
        return cDescribe;
    }

    public void setCDescribe(String cDescribe) {
        this.cDescribe = cDescribe;
    }

    public String getCVurl() {
        return cVurl;
    }

    public void setCVurl(String cVurl) {
        this.cVurl = cVurl;
    }

    public String getCPurl() {
        return cPurl;
    }

    public void setCPurl(String cPurl) {
        this.cPurl = cPurl;
    }

    public Integer getCTime() {
        return cTime;
    }

    public void setCTime(Integer cTime) {
        this.cTime = cTime;
    }

}