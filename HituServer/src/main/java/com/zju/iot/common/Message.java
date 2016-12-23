package com.zju.iot.common;

import java.util.HashMap;

import static com.zju.iot.common.Status.RETURN_OK;

/**
 * Created by amei on 16-12-14.
 * It encapsulate the return values and return status.
 * All the message code and message content is stored in class Status.
 */

public class Message extends HashMap<String,Object>{
    private Status status;
    public Message(Status status){
        super();
        this.status = status;
        put("status",status.getCode());
        put("message",status.getMessage());
    }
    /**
     * the default status is 0 meaning that it is ok
     */
    public Message(){
        super();
        this.status = RETURN_OK;
        put("status",this.status.getCode());
        put("message", this.status.getMessage());
    }

    public void setMessage(Status status){
        this.status = status;
        put("status",status.getCode());
        put("message",status.getMessage());
    }

    /**
     * 存放结果，只能存放一个对象，后来添加的对象会将前边添加的对象覆盖
     * @param object
     */
    public void setResult(Object object){
        put("result",object);
    }

    /**
     * 清空以前的数据
     */
    public void clear(){
        super.clear();
        this.status = RETURN_OK;
    }
    public Object getResult(){
        return get("result");
    }

    public int getStatusCode(){
        return this.status.getCode();
    }
}
