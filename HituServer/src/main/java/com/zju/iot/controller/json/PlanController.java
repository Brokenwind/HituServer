package com.zju.iot.controller.json;

import com.zju.iot.common.Message;
import com.zju.iot.entity.Plan;
import com.zju.iot.service.PlanService;
import com.zju.iot.service.RouteService;
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
    @Inject
    private RouteService routeService;

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

    @RequestMapping("/commit")
    @ResponseBody
    public Message commitPlan(String userID, String planID){
        return planService.commintPlan(userID,planID);
    }

    /**
     * 最近已经创建但是未进行规划的计划
     * @param userID
     * @return
     */
    @RequestMapping("latestUncommitedPlan")
    @ResponseBody
    public Message latestUncommitedPlan(String userID){
        return planService.latestUncommitedPlan(userID);
    }

    /**
     * 最近创建且已经进行规划的计划
     * @param userID
     * @return
     */
    @RequestMapping("latestCommitedPlan")
    @ResponseBody
    public Message latestCommitedPlan(String userID){
        return planService.latestCommitedPlan(userID);
    }

    /**
     * 用户所以已经规划过的计划
     * @param userID
     * @return
     */
    @RequestMapping("/getCommitedPlans")
    @ResponseBody
    public Message getCommited(String userID){
        return planService.getCommitPlans(userID);
    }

}

