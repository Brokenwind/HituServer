package com.zju.iot.common;

/**
 * Created by amei on 16-12-11.
 */
public enum LoginType {
    LOGIN_TYPE_NICKNAME(0),
    LOGIN_TYPE_PHONE(1),
    LOGIN_TYPE_EMAIL(2),
    LOGIN_TYPE_QQ(3),
    LOGIN_TYPE_WEIXIN(4);
    private final int code;
    private LoginType(int code){
        this.code =code;
    }
    public int getCode(){
        return code;
    }
}
