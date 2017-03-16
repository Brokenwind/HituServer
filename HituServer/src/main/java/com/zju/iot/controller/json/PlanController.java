package com.zju.iot.controller.json;

import com.zju.iot.common.Message;
import com.zju.iot.entity.Plan;
import com.zju.iot.service.PlanService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

/**
 * Created by amei on 16-12-27.
 */
@Controller
@RequestMapping("/plan")
public class PlanController {
    private static Logger logger = Logger.getLogger(PlanController.class);
    @Inject
    private PlanService planService;

    @RequestMapping("/add")
    @ResponseBody
    public Message addPlan(Plan plan){
        return planService.addPlan(plan);
    }

    @RequestMapping("/getPlanByPlanID")
    @ResponseBody
    public Message getPlanByPlanID(String userID, String planID){
        return planService.getPlanByPlanID(userID,planID);
    }

    @RequestMapping("latestUncommitedPlan")
    @ResponseBody
    public Message latestUncommitedPlan(String userID){
        return planService.latestUncommitedPlan(userID);
    }

    @RequestMapping("/commit")
    @ResponseBody
    public Message commitPlan(String userID, String planID){
        logger.warn("userID:"+userID+"  planID:"+planID);
        return planService.commintPlan(userID,planID);
    }

}

