package com.gfr.improve.result;

public enum ResponseCode {
    SUCCESS("200", "操作成功"),
    FAILED("999999","操作失败"),
    ParamError("000001", "参数错误！"),
    FileEmpty("000400","上传文件为空"),
    FileType("000403","文件类型错误"),
    LimitPictureSize("000401","图片大小必须小于2M"),
    LimitPictureType("000402","图片格式必须为'jpg'、'png'、'jpge'、'gif'、'bmp'");

    private String code;

    private String msg;

    ResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
