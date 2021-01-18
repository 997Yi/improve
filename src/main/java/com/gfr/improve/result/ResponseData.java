package com.gfr.improve.result;

import com.gfr.improve.result.ResponseCode;

public class ResponseData {

    private String code;

    private String msg;

    private  Integer count;

    private  Object data;



    public ResponseData(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public ResponseData(String code, String msg, Object data,Integer count) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
    }

    public ResponseData(ResponseCode responseCode, Object data) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        this.data = data;
    }

    public ResponseData(ResponseCode responseCode, Object data, Integer count) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        this.data = data;
        this.count = count;
    }

    public ResponseData(String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }
    public ResponseData(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        this.data = null;
    }


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

