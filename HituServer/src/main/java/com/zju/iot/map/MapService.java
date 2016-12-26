package com.zju.iot.map;

import com.zju.iot.entity.*;
import com.zju.iot.map.baidu.entity.BaiduDirection;
import com.zju.iot.map.baidu.entity.BaiduGeoCode;
import com.zju.iot.map.baidu.entity.BaiduRevGeoCode;
import com.zju.iot.map.baidu.entity.BaiduRouteMatrix;

import java.util.List;

/**
 * Created by amei on 16-12-19.
 */
public interface MapService {
    public BaiduDirection getDirection(GeoMark origin, GeoMark destination);
    public BaiduGeoCode getGeoCode(String address, String city);
    public BaiduRevGeoCode getRevGeoCode(GeoMark geoMark);
    public BaiduRouteMatrix getDrivingRouteMatrix(List<GeoMark> origins, List<GeoMark> destinations);
    public BaiduRouteMatrix getRidingRouteMatrix(List<GeoMark> origins, List<GeoMark> destinations);
    public BaiduRouteMatrix getWalkingRouteMatrix(List<GeoMark> origins, List<GeoMark> destinations);
}
