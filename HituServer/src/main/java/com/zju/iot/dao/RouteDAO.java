package com.zju.iot.dao;

import com.zju.iot.entity.Route;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by amei on 16-12-26.
 */
@Component
public class RouteDAO {
    @Inject
    private BaseDAO baseDAO;

    public boolean addRoute(Object object){
        return baseDAO.save(object);
    }
    public boolean batchAddRoutes(List objects){
        return baseDAO.batchSave(objects);
    }
    public Route getRouteByRouteID(String routeID){
        String hsql="from Route route where route.routeID = ?";
        return (Route) baseDAO.uniqueResult(hsql,routeID);
    }

}
