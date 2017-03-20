package com.zju.iot.controller.web;

import com.zju.iot.common.Message;
import com.zju.iot.service.CityService;
import com.zju.iot.service.SceneryService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.Map;

/**
 * Created by amei on 17-1-6.
 */
@Controller
@RequestMapping("/")
public class HomeController {
    private static Logger logger = Logger.getLogger(HomeController.class);
    @Inject
    private SceneryService sceneryService;
    @Inject
    private CityService cityService;

    @RequestMapping("home")
    public String home(Map<String,Object> model, String province, String city){
        Message message = sceneryService.getSceneryByPos(province,city);
        
        Message msg2 = cityService.getCityByName(city);
        if (message.isSuccess()){
            model.put("sceneries",message.getResult());
        }
        else {
            logger.warn("do not get scenery information");
        }
        return "home";
    }
}
