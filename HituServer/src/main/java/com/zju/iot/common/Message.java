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

    public void putResult(Object object){
        put("result",object);
    }

    public Object getResult(){
        return get("result");
    }

    public int getStatusCode(){
        return this.status.getCode();
    }
}
