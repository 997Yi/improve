package com.gfr.improve.entity;

import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/22 10:12
 * @description：解析数据
 * @modified By：
 * @version: 1.0
 */
public class DecryptData {
    private String encryptedData;
    private String sessionKey;
    private String iv;

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }
}
