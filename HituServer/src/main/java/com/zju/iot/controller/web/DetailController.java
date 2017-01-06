package com.zju.iot.controller.web;

import com.zju.iot.common.Message;
import com.zju.iot.service.SceneryImagesService;
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
public class DetailController {
    private static Logger logger = Logger.getLogger(DetailController.class);
    @Inject
    private SceneryService sceneryService;
    @Inject
    private SceneryImagesService imagesService;
    @RequestMapping("/details")
    public String detail(Map<String,Object> model,String name){
        Message scenery = sceneryService.getSceneryByName(name);
        Message pics = imagesService.getImagesBySceneryID(name);
        if (scenery.isSuccess()){
            model.put("scenery",scenery.getResult());
            model.put("pics",pics.getResult());
        }
        else {
            logger.warn("do not get scenery information");
        }
        return "details";
    }
}
