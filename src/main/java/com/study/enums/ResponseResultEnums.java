package com.study.enums;

/**
 * @author lzr
 * @date 2019/11/11 0027 14:48
 */
public enum ResponseResultEnums {

    SUCCESS("1","请求成功"),
    FAIL("-1","请求失败"),
    ERROR("-9","系统错误");

    private String code;// code码
    private String msg;// 消息

    ResponseResultEnums(String code, String msg){this.code=code;this.msg=msg;}

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
