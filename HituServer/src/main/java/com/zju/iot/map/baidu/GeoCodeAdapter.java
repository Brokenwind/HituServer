package com.zju.iot.map.baidu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zju.iot.map.baidu.entity.BaiduGeoCode;
import com.zju.iot.map.baidu.entity.BaiduRevGeoCode;
import org.apache.log4j.Logger;

/**
 * Created by amei on 16-12-20.
 */
public class GeoCodeAdapter {
    private static Logger logger = Logger.getLogger(GeoCodeAdapter.class);
    public static BaiduGeoCode parseGeoCode(String data){
        if (data == null || data.equals(""))
            return null;
        JSONObject ret = JSONObject.parseObject(data);
        int status = ret.getInteger("status");
        BaiduGeoCode geoCode = null;
        if (status == 0){
            JSONObject geoJson = ret.getJSONObject("result");
            geoCode = JSON.parseObject(geoJson.toString(),BaiduGeoCode.class);
        }
        else {
            logger.warn("did not get the BaiduGeoCode object,status: "+String.valueOf(status));
        }
        return geoCode;
    }

    public static BaiduRevGeoCode parseRevGeoCode(String data){
        if (data == null || data.equals(""))
            return null;
        JSONObject ret = JSONObject.parseObject(data);
        int status = ret.getInteger("status");
        BaiduRevGeoCode geoCode = null;
        if (status == 0){
            JSONObject geoJson = ret.getJSONObject("result");
            geoCode = JSON.parseObject(geoJson.toString(),BaiduRevGeoCode.class);
        }
        else {
            logger.warn("did not get the BaiduGeoCode object,status: "+String.valueOf(status));
        }
        return geoCode;
    }

}
