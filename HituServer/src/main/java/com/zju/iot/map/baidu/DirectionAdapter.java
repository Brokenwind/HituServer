package com.zju.iot.map.baidu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zju.iot.entity.Direction;
import org.apache.log4j.Logger;

/**
 * Created by amei on 16-12-19.
 */

public class DirectionAdapter {
    private static Logger logger = Logger.getLogger(DirectionAdapter.class);
    public static Direction getDirection(String data){
        if (data == null || data.equals(""))
            return null;
        JSONObject ret = JSONObject.parseObject(data);
        int status = ret.getInteger("status");
        Direction direction = null;
        if ( status == 0){
            JSONObject directObject = ret.getJSONObject("result");
            direction = JSON.parseObject(directObject.toJSONString(),Direction.class);
        }
        else{
            logger.warn("did not get the Direct object,status: "+String.valueOf(status));
        }
        return direction;
    }
}
