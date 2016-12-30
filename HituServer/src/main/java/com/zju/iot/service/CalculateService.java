package com.zju.iot.service;

import com.zju.iot.common.Message;
import com.zju.iot.entity.Route;
import com.zju.iot.entity.SelectedPoint;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by amei on 16-12-25.
 */
@Component
public class CalculateService {
    @Inject
    private RouteService routeService;
    @Inject
    private SelectedPointService pointService;

    private Message message = new Message();

    /**
     * 规划算法调用处
     * @param planID
     * @return
     */
    public Message programme(String planID){
        ArrayList<SelectedPoint> points = pointService.getPointsByPlanID(planID);
        HashMap<String,Route> routes = routeService.getRoutesByPoints(points);
        message.setResult(routes);
        return message ;
    }
}
