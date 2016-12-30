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

    /**
     *  when the Route object stores in HashMap,it is used to be the key
     * @param start
     * @param end
     * @return
     */
    public static String getRouteKey(GeoMark start,GeoMark end){
        return start.toString()+"-"+end.toString();
    }

    public static String getRouteKey(String start,String end){
        if (start != null && end != null){
            String[] ss = start.split(",");
            String[] ds = start.split(",");
            if ( ss.length == 2 && ds.length == 2) {
                GeoMark s = new GeoMark(Double.valueOf(ss[1]),Double.valueOf(ss[0]));
                GeoMark d = new GeoMark(Double.valueOf(ds[1]),Double.valueOf(ds[0]));
                return getRouteKey(s, d);
            }
        }
        return start+"-"+end;
    }
}
