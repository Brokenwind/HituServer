package com.zju.iot.controller;

import com.zju.iot.common.Message;
import com.zju.iot.service.SceneryImagesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

/**
 * Created by amei on 16-12-10.
 */
@Controller
@RequestMapping("/sceimages")
public class SceneryImagesController {
    @Inject
    private SceneryImagesService service;

    @RequestMapping("/getImagesbySceneryID")
    @ResponseBody
    public Message getImagesBySceneryID(String scenery){
        return service.getImagesBySceneryID(scenery);
    }

    @RequestMapping("/getImagesCount")
    @ResponseBody
    public Message getImageCount(String scenery){
        return service.getImageCount(scenery);
    }
}
