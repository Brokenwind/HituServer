package com.zju.iot.service;

import com.zju.iot.common.Message;
import com.zju.iot.common.Status;
import com.zju.iot.dao.CityDAO;
import com.zju.iot.entity.City;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by amei on 16-12-10.
 */
@Component
public class CityService {
    private static Logger logger = Logger.getLogger(CityService.class);
    @Inject
    private CityDAO dao;
    private Message message = new Message();
    public Message getCityByName(String name){
        message.clear();
        if (name != null && !name.equals("")) {
            City city = dao.getCityByName(name);
            if ( city == null){
                message.setMessage(Status.NO_RESULT);
            }
            else {
                message.setMessage(Status.RETURN_OK);
                message.setResult(city);
            }
        }
        else {
            logger.warn("getCityByName: the parameter name is null or empty");
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        return message;
    }

    public Message getCityByID(String id){
        message.clear();
        if (id != null && !id.equals("")) {
            City city = dao.getCityByID(id);
            if ( city == null){
                message.setMessage(Status.NO_RESULT);
            }
            else {
                message.setMessage(Status.RETURN_OK);
                message.setResult(city);
            }
        }
        else {
            logger.warn("getCityByName: the parameter id is null or empty");
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        return message;
    }

}
