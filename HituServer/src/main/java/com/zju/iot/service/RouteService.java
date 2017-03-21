package com.zju.iot.service;

import com.zju.iot.common.Message;
import com.zju.iot.common.Status;
import com.zju.iot.common.utils.ParseUtil;
import com.zju.iot.dao.RouteDAO;
import com.zju.iot.dao.SchemeDAO;
import com.zju.iot.dao.SelectedPointDAO;
import com.zju.iot.entity.GeoMark;
import com.zju.iot.entity.Route;
import com.zju.iot.entity.SelectedPoint;
import com.zju.iot.map.baidu.Baidu;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by amei on 16-12-26.
 */
@Component
public class RouteService {
    @Inject
    private RouteDAO routeDAO;
    @Inject
    private SchemeDAO schemeDAO;
    @Inject
    private SelectedPointDAO selectedPointDAO;
    @Inject
    private Baidu map;
    private static Logger logger = Logger.getLogger(RouteService.class);
    Message message = new Message();

    /**
     * add a route of the plan
     * @param origin
     * @param destination
     * @return
     */
    public boolean addRoute(String origin,String start, String destination,String end){
        if ( origin == null || destination == null)
            return false;
        else {
            Route route = getLocalRoute(origin,destination);
            if ( route == null ) {
                route = getServerRoute(origin,destination);
                if ( route == null )
                    return false;
                else {
                    route.setStartName(start);
                    route.setEndName(end);
                    return routeDAO.addRoute(route) && schemeDAO.batchAddScheme(route.getSteps());
                }
            }
            else
                return true;
        }
    }

    public boolean addRoute(GeoMark origin, GeoMark destination){
        if ( origin == null || destination == null)
            return false;
        else {
            Route route = getLocalRoute(origin,destination);
            if ( route == null ) {
                route = getServerRoute(origin,destination);
                if ( route == null )
                    return false;
                else {
                    route.setStartName(origin.getName());
                    route.setEndName(destination.getName());
                    return routeDAO.addRoute(route) && schemeDAO.batchAddScheme(route.getSteps());
                }
            }
            else
                return true;
        }
    }

    /**
     * at first we get route from database,if local database do not have the route, and then got the route from service provider.
     * (不包含详细的scheme),当客户端需要的时候再查询详细的scheme
     * @param origin
     * @param destination
     * @return
     */
    public Route getRoute(String origin, String destination){
        message.clear();
        Route route = getLocalRoute(origin,destination);
        if ( route == null ) {
            route = getServerRoute(origin, destination);
            // add the current route to local database.
            routeDAO.addRoute(route);
            // do not provider schemes, so clear it
            route.setSteps(null);
        }
        return route;
    }

    public Route getRoute(GeoMark origin, GeoMark destination){
        message.clear();
        Route route = getLocalRoute(origin,destination);
        if ( route == null ) {
            route = getServerRoute(origin, destination);
            // add the current route to local database.
            routeDAO.addRoute(route);
            // do not provider schemes, so clear it
            if (route != null)
                route.setSteps(null);
        }
        return route;
    }

    /**
     * 获取计划中各个点之间的路径，除了自身和自身的路径
     * @param points
     * @return
     */
    public HashMap<String,Route> getRoutesByPoints(ArrayList<SelectedPoint> points){
        HashMap<String,Route> routes = new HashMap<String, Route>();
        for (SelectedPoint outer: points){
            for (SelectedPoint inner: points){
                GeoMark origin = outer.getMark();
                GeoMark dest = inner.getMark();
                if ( !origin.equals(dest)) {
                    Route route = getLocalRoute(origin, dest);
                    if (route != null)
                        routes.put(ParseUtil.getRouteKey(origin,dest),route);
                    route = getLocalRoute(dest,origin);
                    if (route != null)
                        routes.put(ParseUtil.getRouteKey(dest,origin),route);
                }
            }
        }
        return  routes;
    }

    /**
     * get route from local database
     * (不包含详细的scheme),当客户端需要的时候再查询详细的scheme
     * @param origin
     * @param destination
     * @return
     */
    private Route getLocalRoute(String origin, String destination){
        if ( origin == null || destination == null)
            return null;
        else
            return routeDAO.getRouteByRouteID(ParseUtil.getRouteKey(origin,destination));
    }

    private Route getLocalRoute(GeoMark origin, GeoMark destination){
        if ( origin == null || destination == null)
            return null;
        else
            return routeDAO.getRouteByRouteID(ParseUtil.getRouteKey(origin,destination));
    }

    /**
     * 返回原生的推荐Route对象,内部使用
     * @param origin lat,lng format
     * @param destination lat,lng format
     * @return
     */
    private Route getServerRoute(String origin, String destination) {
        if ( origin == null || destination == null)
            return null;
        else{
            GeoMark or = ParseUtil.parseGeoMark(origin);
            GeoMark de = ParseUtil.parseGeoMark(destination);
            return map.getRecommendRoute(or,de);
        }
    }

    /**
     * 返回原生的推荐Route对象,内部使用
     * @param origin
     * @param destination
     * @return
     */
    private Route getServerRoute(GeoMark origin, GeoMark destination) {
        if ( origin == null || destination == null)
            return null;
        else{
            return map.getRecommendRoute(origin,destination);
        }
    }


    /**
     * 向客户端返回从起点到终点的推荐路径
     * @param origin (String)起点经纬度
     * @param destination (String)终点经纬度
     * @return 推荐路径
     */
    public Message getClientRoute(String origin, String destination){
        message.clear();
        if (origin == null || destination == null){
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        else {
            GeoMark or = ParseUtil.parseGeoMark(origin);
            GeoMark de = ParseUtil.parseGeoMark(destination);
            message = getClientRoute(or,de);
        }
        return  message;
    }

    /**
     * 向客户端返回从起点到终点的推荐路径
     * @param origin (GeoMark)起点经纬度
     * @param destination (GeoMark)终点经纬度
     * @return 推荐路径
     */
    public Message getClientRoute(GeoMark origin, GeoMark destination) {
        message.clear();
        String routeID = ParseUtil.getRouteKey(origin,destination);
        logger.info("routeID is: "+routeID);
        if ( origin == null || destination == null)
            message.setMessage(Status.ILLEGAL_PARAMS);
        else{
            Route route = routeDAO.getRouteByRouteID(routeID);
            if (route == null) {
                logger.warn("database do not have the route, try to get from service provider");
                route = map.getRecommendRoute(origin,destination);
                if ( route == null )
                    message.setMessage(Status.NO_RESULT);
                else {
                    message.setMessage(Status.RETURN_OK);
                    message.setResult(route);
                }
            }
            else
            {
                route.setSteps(schemeDAO.getSchemesByRouteID(routeID));
                message.setMessage(Status.RETURN_OK);
                message.setResult(route);
            }
        }
        return  message;
    }

    /**
     * get the routes of a plan
     * @param planID
     * @return
     */
    public Message getRoutesOfPlan(String planID){
        message.clear();
        ArrayList<Route> routes = new ArrayList<Route>();
        if ( planID != null ){
            ArrayList<SelectedPoint> points = selectedPointDAO.getSelectedPointsByPlanID(planID);
            if ( points != null && points.size() > 0 ){

            }
            else {
                message.setMessage(Status.NO_RESULT);
            }
        }
        else {
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        return message;
    }

}
