package com.zju.iot.controller.json;

import com.zju.iot.common.Message;
import com.zju.iot.service.UserTraceService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

/**
 * Created by amei on 16-12-27.
 */
@Controller
@RequestMapping("/trace")
public class UserTraceController {
    private static Logger logger = Logger.getLogger(UserTraceController.class);
    @Inject
    private UserTraceService traceService;

    @RequestMapping("/add")
    @ResponseBody
    public Message addUserTrace(String userID,Double lng,Double lat){
        return traceService.addUserTrace(userID,lng,lat);
    }

    /**
     * 用户所以已经规划过的计划
     * @param userID
     * @return
     */
    @RequestMapping("/getTraces")
    @ResponseBody
    public Message getCommited(String userID){
        return traceService.getTraces(userID);
    }

}

