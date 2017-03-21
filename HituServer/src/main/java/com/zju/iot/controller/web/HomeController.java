package com.zju.iot.controller.web;

import com.zju.iot.common.Message;
import com.zju.iot.entity.City;
import com.zju.iot.entity.CityImages;
import com.zju.iot.service.CityImagesService;
import com.zju.iot.service.CityService;
import com.zju.iot.service.SceneryService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.ArrayList;
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
    @Inject
    private CityImagesService cityImagesService;
    @RequestMapping("home")
    public String home(Map<String,Object> model, String province, String city){
        Message message = sceneryService.getSceneryByPos(province,city);
        Message msg2 = cityService.getCityByName(city);
        if (message.isSuccess() && msg2.isSuccess()){
            City city1 = (City) msg2.getResult();
            Message msg3 = cityImagesService.getImagesByCityID(city1.getCityID());
            model.put("sceneries",message.getResult());
            model.put("city",msg2.getResult());
            if ( msg3.isSuccess() )
                model.put("images",msg3.getResult());
            else
                model.put("images",new ArrayList<CityImages>());
        }
        else {
            logger.warn("do not get scenery information");
        }
        return "home";
    }
}
