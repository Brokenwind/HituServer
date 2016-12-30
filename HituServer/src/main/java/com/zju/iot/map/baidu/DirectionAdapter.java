package com.zju.iot.map.baidu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zju.iot.common.utils.ParseUtil;
import com.zju.iot.entity.GeoMark;
import com.zju.iot.entity.Route;
import com.zju.iot.entity.Scheme;
import com.zju.iot.map.baidu.entity.BaiduDirection;
import com.zju.iot.map.baidu.entity.BaiduRoute;
import com.zju.iot.map.baidu.entity.BaiduScheme;
import com.zju.iot.map.baidu.entity.BaiduVehicleDetail;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by amei on 16-12-19.
 */

public class DirectionAdapter {
    private static Logger logger = Logger.getLogger(DirectionAdapter.class);

    public static BaiduDirection parseDirection(String data){
        if (data == null || data.equals(""))
            return null;
        JSONObject ret = JSONObject.parseObject(data);
        int status = ret.getInteger("status");
        BaiduDirection direction = null;
        if ( status == 0){
            JSONObject directObject = ret.getJSONObject("result");
            direction = JSON.parseObject(directObject.toJSONString(),BaiduDirection.class);
        }
        else{
            logger.warn("did not get the Direct object,status: "+String.valueOf(status));
        }
        return direction;
    }

    /**
     * get the fist route of the return direction routes.
     * Transform the Direction content to Route object
     * @param data
     * @return
     */
    public static Route parseFirstRoute(GeoMark origin, GeoMark destination,String data){
        if (data == null || data.equals(""))
            return null;
        Route route = null;
        BaiduDirection direction = parseDirection(data);
        if ( direction != null ){
            BaiduRoute baiduRoute = direction.getRoutes().get(0);
            route = new Route();
            route.setStart(direction.getOrigin().getLocation());
            route.setEnd(direction.getDestination().getLocation());
            // routeID is generate with startGeoMark and endGeoMark.
            String routeID = ParseUtil.getRouteKey(origin,destination);
            route.setRouteID(routeID);
            route.setDistance(baiduRoute.getDistance());
            route.setDuration(baiduRoute.getDuration());
            route.setArriveTime(baiduRoute.getArrive_time());
            route.setPrice(baiduRoute.getPrice());
            route.setStepcount(baiduRoute.getSteps().size());
            ArrayList<Scheme> schemes = new ArrayList<Scheme>();
            int step = 0;
            int schemenum = 0;
            for (ArrayList<BaiduScheme> baiduSchemes: baiduRoute.getSteps()) { // every step of a route
                schemenum = 0;
                for (BaiduScheme baiduScheme : baiduSchemes) { // every sub step of a step
                    Scheme scheme = new Scheme();
                    scheme.setRouteID(routeID);
                    scheme.setSchemeID(UUID.randomUUID().toString());
                    scheme.setStepnum(step);
                    scheme.setSchemenum(schemenum++);
                    scheme.setDistance(baiduScheme.getDistance());
                    scheme.setDuration(baiduScheme.getDuration());
                    scheme.setInstructions(baiduScheme.getInstructions());
                    scheme.setPath(baiduScheme.getPath());
                    scheme.setStart(baiduScheme.getStart_location());
                    scheme.setEnd(baiduScheme.getEnd_location());
                    scheme.setVehicleType(baiduScheme.getVehicle_info().getType());
                    BaiduVehicleDetail detail = baiduScheme.getVehicle_info().getDetail();
                    if (detail != null) {
                        scheme.setVehicleName(detail.getName());
                        scheme.setPrice(detail.getPrice());
                        scheme.setBooking(detail.getBooking());
                        scheme.setDepartureStation(detail.getDeparture_station());
                        scheme.setArriveStation(detail.getArrive_station());
                        scheme.setDepartureTime(detail.getDeparture_time());
                        scheme.setArriveTime(detail.getArrive_time());
                        scheme.setPublicType(detail.getType());
                        scheme.setStopNum(detail.getStop_num());
                        scheme.setOffStation(detail.getOff_station());
                        scheme.setOnStation(detail.getOn_station());
                        scheme.setLastTime(detail.getLast_time());
                        scheme.setProviderName(detail.getProvider_name());
                        scheme.setProviderUrl(detail.getProvider_url());
                        scheme.setAirlines(detail.getAirlines());
                        scheme.setDiscount(detail.getDiscount());
                        schemes.add(scheme);
                    }
                }
                step ++;
            }
            route.setSteps(schemes);
        }
        return route;
    }
}
