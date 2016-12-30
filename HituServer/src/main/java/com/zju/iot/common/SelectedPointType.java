package com.zju.iot.common;

/**
 * Created by amei on 12/29/16.
 */
public enum  SelectedPointType {
    // the point is the start point
    START(0),
    // the point is the place you will to
    MEDIUM(1),
    // the destination of this plan
    END(20);
    private int code;
    private SelectedPointType(int code){
        this.code = code;
    }
    public int getCode() {
        return code;
    }
}
