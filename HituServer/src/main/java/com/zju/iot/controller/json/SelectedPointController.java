package com.zju.iot.controller.json;

import com.zju.iot.common.Message;
import com.zju.iot.common.SelectedPointType;
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

    @RequestMapping("addMediumPoint")
    @ResponseBody
    public Message addMediumPoint(String planID,Double lng, Double lat, String name, String openTime, String closeTime, Integer stayTime, String level, Double price ){
        return service.addSelectedPoint(planID, SelectedPointType.MEDIUM.getCode(),lng,lat,name,openTime,closeTime,stayTime,level,price);
    }

    @RequestMapping("addStartPoint")
    @ResponseBody
    public Message addStartPoint(String planID,Double lng, Double lat, String name, String openTime, String closeTime, Integer stayTime, String level, Double price ){
        return service.addStartPoint(planID, SelectedPointType.START.getCode(),lng,lat,name,openTime,closeTime,stayTime,level,price);
    }

    @RequestMapping("addEndPoint")
    @ResponseBody
    public Message addEndPoint(String planID,Double lng, Double lat, String name, String openTime, String closeTime, Integer stayTime, String level, Double price ){
        return service.addSelectedPoint(planID, SelectedPointType.END.getCode(),lng,lat,name,openTime,closeTime,stayTime,level,price);
    }

    /**
     * 删除规划中的中间节点，除去开始节点和最终节点
     * @param planID
     * @param lng
     * @param lat
     * @return
     */
    @RequestMapping("deleteMediumPoint")
    @ResponseBody
    public Message deleteSelectedPoint(String planID,String lng,String lat){
        System.out.println("Test "+planID+" "+lng+" "+lat);
        return service.deleteSelectedPoint(planID,SelectedPointType.MEDIUM.getCode(),lng,lat);
    }

    @RequestMapping("getSelectedPointsByPlanID")
    @ResponseBody
    public Message getSelectedPointsByPlanID(String planID){
        return service.getSelectedPointsByPlanID(planID);
    }

    @RequestMapping("updateStartPoint")
    @ResponseBody
    public Message updateStartPoint(String planID,Double lng, Double lat, String name, String openTime, String closeTime, Integer stayTime, String level, Double price ){
        return service.updateSpecialPoint(planID, SelectedPointType.START.getCode(),lng,lat,name,openTime,closeTime,stayTime,level,price);
    }

    @RequestMapping("updateEndPoint")
    @ResponseBody
    public Message updateEndPoint(String planID,Double lng, Double lat, String name, String openTime, String closeTime, Integer stayTime, String level, Double price ){
        return service.updateSpecialPoint(planID, SelectedPointType.END.getCode(),lng,lat,name,openTime,closeTime,stayTime,level,price);
    }
}
