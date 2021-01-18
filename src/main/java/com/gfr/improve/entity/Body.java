package com.gfr.improve.entity;

import java.io.Serializable;

/**
 * (Body)实体类
 *
 * @author makejava
 * @since 2021-01-18 13:47:06
 */
public class Body implements Serializable {
    private static final long serialVersionUID = -85609931710428423L;
    /**
     * 对应用户id
     */
    private String userId;
    /**
     * 身高cm
     */
    private Object height;
    /**
     * 体重kg
     */
    private Object weight;
    /**
     * 胸围
     */
    private String chestCircumference;
    /**
     * 腰围
     */
    private String waistline;
    /**
     * 臀围
     */
    private String hipline;
    /**
     * 体脂肪率%
     */
    private Object bodyFatRate;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Object getHeight() {
        return height;
    }

    public void setHeight(Object height) {
        this.height = height;
    }

    public Object getWeight() {
        return weight;
    }

    public void setWeight(Object weight) {
        this.weight = weight;
    }

    public String getChestCircumference() {
        return chestCircumference;
    }

    public void setChestCircumference(String chestCircumference) {
        this.chestCircumference = chestCircumference;
    }

    public String getWaistline() {
        return waistline;
    }

    public void setWaistline(String waistline) {
        this.waistline = waistline;
    }

    public String getHipline() {
        return hipline;
    }

    public void setHipline(String hipline) {
        this.hipline = hipline;
    }

    public Object getBodyFatRate() {
        return bodyFatRate;
    }

    public void setBodyFatRate(Object bodyFatRate) {
        this.bodyFatRate = bodyFatRate;
    }

}