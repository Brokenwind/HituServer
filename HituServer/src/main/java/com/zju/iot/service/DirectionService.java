package com.zju.iot.service;

import com.zju.iot.common.Message;
import com.zju.iot.common.Status;
import com.zju.iot.common.utils.ParseUtil;
import com.zju.iot.entity.Direction;
import com.zju.iot.entity.GeoMark;
import com.zju.iot.entity.Route;
import com.zju.iot.map.baidu.Baidu;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by amei on 16-12-22.
 * 提供了线路规划功能
 */
@Component
public class DirectionService {
    @Inject
    Baidu map;
    private Message message = new Message();

    /**
     * 获取从起点到终点的推荐路径
     * @param origin (String)起点经纬度
     * @param destination (String)终点经纬度
     * @return 推荐路径
     */
    public Message getRecommendRoute(String origin, String destination){
        if (origin == null || destination == null){
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        else {
            GeoMark or = ParseUtil.parseGeoMark(origin);
            GeoMark de = ParseUtil.parseGeoMark(destination);
            message = getRecommendRoute(or,de);
        }
        return  message;
    }

    /**
     * 获取从起点到终点的推荐路径
     * @param origin (GeoMark)起点经纬度
     * @param destination (GeoMark)终点经纬度
     * @return 推荐路径
     */
    public Message getRecommendRoute(GeoMark origin, GeoMark destination) {
        if ( origin == null || destination == null)
            message.setMessage(Status.ILLEGAL_PARAMS);
        else{
            Direction direction = map.getDirection(origin,destination);
            if ( direction == null )
                message.setMessage(Status.NO_RESULT);
            else{
                ArrayList<Route> routes = direction.getRoutes();
                if ( routes == null || routes.size() == 0 )
                    message.setMessage(Status.NO_RESULT);
                else {
                    message.setMessage(Status.RETURN_OK);
                    message.putResult(routes.get(0));
                }
            }
        }
        return  message;
    }

}
