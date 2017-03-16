package com.zju.iot.controller.web;

import com.zju.iot.common.Message;
import com.zju.iot.entity.Route;
import com.zju.iot.service.PlanService;
import com.zju.iot.service.SceneryService;
import com.zju.iot.service.SelectedPointService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Created by amei on 17-1-11.
 */
@Controller
@RequestMapping("/plan")
public class PlanpersController {
    private static Logger logger = Logger.getLogger(PlanpersController.class);
    @Inject
    private SelectedPointService selectedPointService;
    @Inject
    private SceneryService sceneryService;
    @Inject
    private PlanService planService;

    @RequestMapping("/current")
    public String current(Map<String,Object> model,String planID){
        if ( planID != null ){
            model.put("sceneries", sceneryService.getSceneryByPoints(selectedPointService.getPointsByPlanID(planID)));
        }
        return "plans-personal";
    }

    @RequestMapping("/result")
    public String result(Map<String,Object> model,String userID,String planID){
        if ( planID != null ){
            Message msg = planService.commintPlan(userID,planID);
            if (msg.isSuccess()) {
                List<Route> routes = (List<Route>) msg.getResult();
                model.put("routes",routes);
            }
        }
        return "plans-result";
    }

    @RequestMapping("/history")
    public String history(Map<String,Object> model){

        return "plans-personal";
    }



}
