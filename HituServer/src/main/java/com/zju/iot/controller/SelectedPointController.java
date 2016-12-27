package com.zju.iot.controller;

import com.zju.iot.common.Message;
import com.zju.iot.service.SelectedPointService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

/**
 * Created by amei on 16-12-27.
 */
@Controller
@RequestMapping("/point")
public class SelectedPointController {
    @Inject
    private SelectedPointService service;

    @RequestMapping("add")
    @ResponseBody
    public Message addSelectedPoint(String planID, Double lng, Double lat, String openTime, String closeTime, Integer stayTime, String level, Double price ){
        return service.addSelectedPoint(planID,lng,lat,openTime,closeTime,stayTime,level,price);
    }

    @RequestMapping("delete")
    @ResponseBody
    public Message deleteSelectedPoint(String planID,String selectedID){
        return service.deleteSelectedPoint(planID,selectedID);
    }

    @RequestMapping("getSelectedPointsByPlanID")
    @ResponseBody
    public Message getSelectedPointsByPlanID(String planID){
        return service.getSelectedPointsByPlanID(planID);
    }


}
