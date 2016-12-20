package com.zju.iot.map.baidu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by amei on 16-12-20.
 */
public  class BaseAdapter {
    public Object getObject(String data,Class clas){
        if (data == null || data.equals(""))
            return null;
        JSONObject ret = JSONObject.parseObject(data);
        int status = ret.getInteger("status");
        Object object = null;
        if ( status == 0){
            JSONObject resultObject = ret.getJSONObject("result");
            object = JSON.parseObject(resultObject.toJSONString(),clas);
        }
        return object;
    }
}
