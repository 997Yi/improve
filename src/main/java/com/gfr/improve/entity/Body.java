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
    private String height;
    /**
     * 体重kg
     */
    private String weight;
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
    private String bodyFatRate;

    private String value;

    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }




    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
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

    public String getBodyFatRate() {
        return bodyFatRate;
    }

    public void setBodyFatRate(String bodyFatRate) {
        this.bodyFatRate = bodyFatRate;
    }

}