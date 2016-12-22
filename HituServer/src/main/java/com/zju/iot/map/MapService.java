package com.zju.iot.map;

import com.zju.iot.entity.*;

import java.util.List;

/**
 * Created by amei on 16-12-19.
 */
public interface MapService {
    public Direction getDirection(GeoMark origin, GeoMark destination);
    public GeoCode getGeoCode(String address,String city);
    public RevGeoCode getRevGeoCode(GeoMark geoMark);
    public RouteMatrix getDrivingRouteMatrix(List<GeoMark> origins,List<GeoMark> destinations);
    public RouteMatrix getRidingRouteMatrix(List<GeoMark> origins,List<GeoMark> destinations);
    public RouteMatrix getWalkingRouteMatrix(List<GeoMark> origins,List<GeoMark> destinations);
}
