package com.zju.iot.common.utils;

import com.zju.iot.entity.GeoMark;

/**
 * Created by amei on 16-12-22.
 * 处理各种对象之间的转化
 */
public class ParseUtil {
    public static GeoMark parseGeoMark(String str){
        if (str == null )
            return null;
        else {
            GeoMark mark = new GeoMark();
            String[] ret = str.split(",");
            if (ret.length != 2)
                return null;
            else{
                try {
                    mark.setLat(Double.valueOf(ret[0]));
                    mark.setLng(Double.valueOf(ret[1]));
                }catch (Exception e){
                    mark = null;
                }
            }
            return  mark;
        }
    }
}
