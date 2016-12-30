package com.zju.iot.service;

import com.zju.iot.common.Message;
import com.zju.iot.common.Status;
import com.zju.iot.common.utils.ParseUtil;
import com.zju.iot.map.baidu.entity.BaiduDirection;
import com.zju.iot.entity.GeoMark;
import com.zju.iot.map.baidu.entity.BaiduRoute;
import com.zju.iot.map.baidu.Baidu;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by amei on 16-12-22.
 * 提供了线路规划功能
 */
@Deprecated
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
        message.clear();
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
        message.clear();
        if ( origin == null || destination == null)
            message.setMessage(Status.ILLEGAL_PARAMS);
        else{
            BaiduDirection direction = map.getDirection(origin,destination);
            if ( direction == null )
                message.setMessage(Status.NO_RESULT);
            else{
                ArrayList<BaiduRoute> routes = direction.getRoutes();
                if ( routes == null || routes.size() == 0 )
                    message.setMessage(Status.NO_RESULT);
                else {
                    message.setMessage(Status.RETURN_OK);
                    message.setResult(routes.get(0));
                }
            }
        }
        return  message;
    }

    /**
     * 返回原生的推荐Route对象
     * @param origin
     * @param destination
     * @return
     */
    public BaiduRoute getOriginRecommendRoute(GeoMark origin, GeoMark destination) {
        if ( origin == null || destination == null)
            return null;
        else{
            BaiduDirection direction = map.getDirection(origin,destination);
            if ( direction == null )
                return null;
            else{
                ArrayList<BaiduRoute> routes = direction.getRoutes();
                if ( routes == null || routes.size() == 0 )
                    return null;
                else
                    return routes.get(0);
            }
        }
    }

    public Message getRecommendRouteDuration(String origin, String destination){
        message.clear();
        if (origin == null || destination == null){
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        else {
            GeoMark or = ParseUtil.parseGeoMark(origin);
            GeoMark de = ParseUtil.parseGeoMark(destination);
            message = getRecommendRouteDuration(or,de);
        }
        return  message;
    }

    public Message getRecommendRouteDuration(GeoMark origin, GeoMark destination) {
        message.clear();
        if ( origin == null || destination == null)
            message.setMessage(Status.ILLEGAL_PARAMS);
        else{
            BaiduDirection direction = map.getDirection(origin,destination);
            if ( direction == null )
                message.setMessage(Status.NO_RESULT);
            else{
                ArrayList<BaiduRoute> routes = direction.getRoutes();
                if ( routes == null || routes.size() == 0 )
                    message.setMessage(Status.NO_RESULT);
                else {
                    message.setMessage(Status.RETURN_OK);
                    message.setResult(routes.get(0).getDuration());
                }
            }
        }
        return  message;
    }
}
