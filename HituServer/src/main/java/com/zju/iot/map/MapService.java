package com.zju.iot.map;

import com.zju.iot.entity.Direction;
import com.zju.iot.entity.GeoCode;
import com.zju.iot.entity.GeoMark;
import com.zju.iot.entity.RevGeoCode;

/**
 * Created by amei on 16-12-19.
 */
public interface MapService {
    public Direction getDirection(GeoMark origin, GeoMark destination);
    public GeoCode getGeoCode(String address,String city);
    public RevGeoCode getRevGeoCode(GeoMark geoMark);
}
