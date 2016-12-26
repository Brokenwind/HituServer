package com.zju.iot.service;

import com.zju.iot.common.Message;
import com.zju.iot.common.utils.ParseUtil;
import com.zju.iot.entity.GeoMark;
import com.zju.iot.map.baidu.entity.BaiduRouteMatrix;
import com.zju.iot.map.baidu.entity.BaiduRouteMatrixItem;
import com.zju.iot.map.baidu.Baidu;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by amei on 16-12-24.
 */
@Component
public class MatrixService {
    @Inject
    private Baidu baidu;
    private Message message = new Message();

    /**
     *驾车从起点到终点的距离和时间
     * @param origin 起点坐标
     * @param destination 终点坐标
     * @return
     */
    public BaiduRouteMatrixItem calculateSingleDrivingRoute(String origin, String destination){
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
                BaiduRouteMatrix matrix = baidu.getDrivingRouteMatrix(ors,des);
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
    public BaiduRouteMatrixItem calculateSingleRidingRoute(String origin, String destination){
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
                BaiduRouteMatrix matrix = baidu.getRidingRouteMatrix(ors,des);
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
    public BaiduRouteMatrixItem calculateSingleWalkingRoute(String origin, String destination){
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
                BaiduRouteMatrix matrix = baidu.getWalkingRouteMatrix(ors,des);
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
