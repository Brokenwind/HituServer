package com.zju.iot.map.baidu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zju.iot.entity.GeoCode;
import com.zju.iot.entity.RevGeoCode;
import org.apache.log4j.Logger;

/**
 * Created by amei on 16-12-20.
 */
public class GeoCodeAdapter {
    private static Logger logger = Logger.getLogger(GeoCodeAdapter.class);
    public static GeoCode parseGeoCode(String data){
        if (data == null || data.equals(""))
            return null;
        JSONObject ret = JSONObject.parseObject(data);
        int status = ret.getInteger("status");
        GeoCode geoCode = null;
        if (status == 0){
            JSONObject geoJson = ret.getJSONObject("result");
            geoCode = JSON.parseObject(geoJson.toString(),GeoCode.class);
        }
        else {
            logger.warn("did not get the GeoCode object,status: "+String.valueOf(status));
        }
        return geoCode;
    }

    public static RevGeoCode parseRevGeoCode(String data){
        if (data == null || data.equals(""))
            return null;
        JSONObject ret = JSONObject.parseObject(data);
        int status = ret.getInteger("status");
        RevGeoCode geoCode = null;
        if (status == 0){
            JSONObject geoJson = ret.getJSONObject("result");
            geoCode = JSON.parseObject(geoJson.toString(),RevGeoCode.class);
        }
        else {
            logger.warn("did not get the GeoCode object,status: "+String.valueOf(status));
        }
        return geoCode;
    }

}
