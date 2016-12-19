package com.zju.iot.controller;

import com.zju.iot.common.Message;
import com.zju.iot.map.ApiFactory;
import com.zju.iot.common.ServiceProvider;
import com.zju.iot.service.SceneryService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

/**
 * Created by amei on 16-12-10.
 */
@Controller
@RequestMapping("/scenery")
public class SceneryController {
    private static Logger logger = Logger.getLogger(SceneryController.class);
    @Inject
    private SceneryService service;

    /***
     * 根据景点的名称呢个获取相应的景点信息
     * @param name
     * @return
     */
    @RequestMapping("/getSceneryByName")
    @ResponseBody
    public Message getSceneryByName(String name){
        return service.getSceneryByName(name);
    }

    /**
     * 根据景点的ID呢个获取相应的景点信息
     * @param id
     * @return
     */
    @RequestMapping("/getSceneryByID")
    @ResponseBody
    public Message getSceneryByID(String id){
        return service.getSceneryByID(id);
    }

    /**
     * 获取指定的省份和城市的景点列表
     * @param province
     * @param city
     * @return
     */
    @RequestMapping("/getSceneryByPos")
    @ResponseBody
    public Message getSceneryByPos(String province, String city){
        return service.getSceneryByPos(province,city);
    }

    /**
     * 获取总的景点数量
     * @return
     */
    @RequestMapping("/getTotalSceneryNum")
    @ResponseBody
    public Message getTotalSceneryNum(){
        return service.getSceneryCount();
    }

    /**
     * 获取指定省份的景点数量
     * @param province
     * @return
     */
    @RequestMapping("/getProvinceSceneryNum")
    @ResponseBody
    public Message getProvinceSceneryNum(String province){
        return service.getSceneryCount(province);
    }

    /**
     * 获取指定省份和城市的景点数量
     * @param province
     * @param city
     * @return
     */
    @RequestMapping("/getPosSceneryNum")
    @ResponseBody
    public Message getPosSceneryNum(String province,String city){
        return service.getSceneryCount(province,city);
    }

    /**
     * 分页获取指定省份和城市的景点列表。
     * @param province
     * @param city
     * @param start 开始位置
     * @param num 指定的数量
     * @return
     */
    @RequestMapping("/getPagedSceneryByPos")
    @ResponseBody
    public Message getPagedSceneryByPos(String province, String city,int start,int num){
        return service.getPagedSceneryByPos(province,city,start,num);
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return ApiFactory.getApiConfig(ServiceProvider.BAIDU_API.getName()).getBaseUrl();
    }
}
