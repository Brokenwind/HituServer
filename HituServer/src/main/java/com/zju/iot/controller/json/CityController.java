package com.zju.iot.controller.json;

import com.zju.iot.common.Message;
import com.zju.iot.service.CityService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

/**
 * Created by amei on 16-12-10.
 */
@Controller
@RequestMapping("/city")
public class CityController {
    private static Logger logger = Logger.getLogger(CityController.class);
    @Inject
    private CityService service;

    /***
     * 根据景点的名称呢个获取相应的景点信息
     * @param name
     * @return
     */
    @RequestMapping("/getCityByName")
    @ResponseBody
    public Message getCityByName(String name){
        return service.getCityByName(name);
    }

    /**
     * 根据景点的ID呢个获取相应的景点信息
     * @param id
     * @return
     */
    @RequestMapping("/getCityByID")
    @ResponseBody
    public Message getCityByID(String id){
        return service.getCityByID(id);
    }

}
