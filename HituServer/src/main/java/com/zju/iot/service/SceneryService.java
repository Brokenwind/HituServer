package com.zju.iot.service;

import com.zju.iot.common.Message;
import com.zju.iot.common.Status;
import com.zju.iot.dao.SceneryDAO;
import com.zju.iot.entity.Scenery;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by amei on 16-12-10.
 */
@Component
public class SceneryService {
    private static Logger logger = Logger.getLogger(SceneryService.class);
    @Inject
    private SceneryDAO dao;
    private Message message = new Message();
    public Message getSceneryByName(String name){
        if (name != null && !name.equals("")) {
            Scenery scenery = dao.getSceneryByName(name);
            if ( scenery == null){
                message.setMessage(Status.NO_RESULT);
            }
            else {
                message.setMessage(Status.RETURN_OK);
                message.putResult(scenery);
            }
        }
        else {
            logger.warn("getSceneryByName: the parameter name is null or empty");
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        return message;
    }

    public Message getSceneryByID(String id){
        if (id != null && !id.equals("")) {
            Scenery scenery = dao.getSceneryByID(id);
            if ( scenery == null){
                message.setMessage(Status.NO_RESULT);
            }
            else {
                message.setMessage(Status.RETURN_OK);
                message.putResult(scenery);
            }
        }
        else {
            logger.warn("getSceneryByName: the parameter id is null or empty");
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        return message;
    }

    public Message getSceneryByPos(String province, String city){
        if ( province != null && city != null && !province.equals("") && !city.equals("")){
            List<Scenery> sceneries = dao.getSceneryByPos(province,city);
            if ( sceneries == null || sceneries.size() == 0){
                message.setMessage(Status.NO_RESULT);
            }
            else {
                message.setMessage(Status.RETURN_OK);
                message.putResult(sceneries);
            }
        }
        else {
            logger.warn("getSceneryByName: the parameter province or city is not right");
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        return message;
    }

    public Message getPagedSceneryByPos(String province, String city,int start,int num){
        if ( province != null && city != null && !province.equals("") && !city.equals("") && start >= 0 && num > 0){
            List<Scenery> sceneries = dao.getPagedSceneryByPos(province,city,start,num);
            if ( sceneries == null || sceneries.size() == 0){
                message.setMessage(Status.NO_RESULT);
            }
            else {
                message.setMessage(Status.RETURN_OK);
                message.putResult(sceneries);
            }
        }
        else {
            logger.warn("getSceneryByName: the parameter province or city is not right");
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        return message;
    }

    public Message getSceneryCount(){
        message.setMessage(Status.RETURN_OK);
        message.putResult(dao.getSceneryCount());
        return message;
    }

    public Message getSceneryCount(String province){
        if ( province != null && !province.equals("")) {
            message.setMessage(Status.RETURN_OK);
            message.putResult(dao.getSceneryCount(province));
        }
        else {
            logger.warn("the parameter is not right");
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        return message;
    }

    public Message getSceneryCount(String province,String city){
        if ( province != null && city != null && !province.equals("") && !city.equals("")) {
            message.setMessage(Status.RETURN_OK);
            message.putResult(dao.getSceneryCount(province,city));
        }
        else {
            logger.warn("the parameters is not right");
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        return message;
    }

}
