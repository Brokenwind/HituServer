package com.zju.iot.service;

import com.zju.iot.common.Message;
import com.zju.iot.dao.RouteDAO;
import com.zju.iot.dao.SchemeDAO;
import com.zju.iot.map.baidu.Baidu;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by amei on 16-12-26.
 */
@Component
public class RouteService {
    @Inject
    private RouteDAO routeDAO;
    @Inject
    private SchemeDAO schemeDAO;
    @Inject
    private Baidu baidu;

    Message message = new Message();

    public Message addDestination(){
        message.clear();
        return message;
    }
}
