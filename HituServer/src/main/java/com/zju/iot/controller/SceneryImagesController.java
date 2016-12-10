package com.zju.iot.controller;

import com.zju.iot.entity.SceneryImages;
import com.zju.iot.service.SceneryImagesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.ArrayList;

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
    public ArrayList<SceneryImages> getImagesBySceneryID(String sceneryID){
        return service.getImagesBySceneryID(sceneryID);
    }

    @RequestMapping("/getImagesCount")
    @ResponseBody
    public int getImageCount(String sceneryID){
        return service.getImageCount(sceneryID);
    }
}
