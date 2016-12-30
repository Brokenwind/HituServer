package com.zju.iot.controller;

import com.zju.iot.common.Message;
import com.zju.iot.service.RouteService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

/**
 * Created by amei on 16-12-28.
 */
@Component
@RequestMapping("/route")
public class RouteController {
    @Inject
    private RouteService service;

    @RequestMapping("getClientRoute")
    @ResponseBody
    public Message getClientRoute(String origin, String destination){
        return service.getClientRoute(origin,destination);
    }

    @RequestMapping("add")
    @ResponseBody
    public boolean addRoute(String origin, String destination,String planID){
        return service.addRoute(origin,destination);
    }


}
