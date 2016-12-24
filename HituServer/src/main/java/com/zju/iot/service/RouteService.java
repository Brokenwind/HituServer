package com.zju.iot.service;

import com.zju.iot.common.Message;
import com.zju.iot.common.utils.ParseUtil;
import com.zju.iot.entity.GeoMark;
import com.zju.iot.entity.RouteMatrix;
import com.zju.iot.entity.RouteMatrixItem;
import com.zju.iot.map.baidu.Baidu;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by amei on 16-12-24.
 */
@Component
public class RouteService {
    private Baidu baidu = new Baidu();
    private Message message = new Message();

    /**
     *驾车从起点到终点的距离和时间
     * @param origin 起点坐标
     * @param destination 终点坐标
     * @return
     */
    public RouteMatrixItem calculateSingleDrivingRoute(String origin,String destination){
        if ( origin == null || destination == null)
            return null;
        else {
            GeoMark or = ParseUtil.parseGeoMark(origin);
            GeoMark de = ParseUtil.parseGeoMark(destination);
            if ( or != null && de != null) {
                ArrayList<GeoMark> ors = new ArrayList<GeoMark>();
                ArrayList<GeoMark> des = new ArrayList<GeoMark>();
                ors.add(or);
                des.add(de);
                RouteMatrix matrix = baidu.getDrivingRouteMatrix(ors,des);
                if (matrix != null && matrix.getResult() != null && matrix.getResult().size() > 0)
                    return matrix.getResult().get(0);
                else
                    return null;
            }
            else
                return null;
        }
    }

    /**
     *驾车从起点到终点的距离和时间
     * @param origin 起点坐标
     * @param destination 终点坐标
     * @return
     */
    public RouteMatrixItem calculateSingleRidingRoute(String origin,String destination){
        if ( origin == null || destination == null)
            return null;
        else {
            GeoMark or = ParseUtil.parseGeoMark(origin);
            GeoMark de = ParseUtil.parseGeoMark(destination);
            if ( or != null && de != null) {
                ArrayList<GeoMark> ors = new ArrayList<GeoMark>();
                ArrayList<GeoMark> des = new ArrayList<GeoMark>();
                ors.add(or);
                des.add(de);
                RouteMatrix matrix = baidu.getRidingRouteMatrix(ors,des);
                if (matrix != null && matrix.getResult() != null && matrix.getResult().size() > 0)
                    return matrix.getResult().get(0);
                else
                    return null;
            }
            else
                return null;
        }
    }


    /**
     *驾车从起点到终点的距离和时间
     * @param origin 起点坐标
     * @param destination 终点坐标
     * @return
     */
    public RouteMatrixItem calculateSingleWalkingRoute(String origin,String destination){
        if ( origin == null || destination == null)
            return null;
        else {
            GeoMark or = ParseUtil.parseGeoMark(origin);
            GeoMark de = ParseUtil.parseGeoMark(destination);
            if ( or != null && de != null) {
                ArrayList<GeoMark> ors = new ArrayList<GeoMark>();
                ArrayList<GeoMark> des = new ArrayList<GeoMark>();
                ors.add(or);
                des.add(de);
                RouteMatrix matrix = baidu.getWalkingRouteMatrix(ors,des);
                if (matrix != null && matrix.getResult() != null && matrix.getResult().size() > 0)
                    return matrix.getResult().get(0);
                else
                    return null;
            }
            else
                return null;
        }
    }

}
