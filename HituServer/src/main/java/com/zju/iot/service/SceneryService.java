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
        message.clear();
        if (name != null && !name.equals("")) {
            Scenery scenery = dao.getSceneryByName(name);
            if ( scenery == null){
                message.setMessage(Status.NO_RESULT);
            }
            else {
                message.setMessage(Status.RETURN_OK);
                message.setResult(scenery);
            }
        }
        else {
            logger.warn("getSceneryByName: the parameter name is null or empty");
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        return message;
    }

    public Message getSceneryByID(String id){
        message.clear();
        if (id != null && !id.equals("")) {
            Scenery scenery = dao.getSceneryByID(id);
            if ( scenery == null){
                message.setMessage(Status.NO_RESULT);
            }
            else {
                message.setMessage(Status.RETURN_OK);
                message.setResult(scenery);
            }
        }
        else {
            logger.warn("getSceneryByName: the parameter id is null or empty");
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        return message;
    }

    public Message getSceneryByPos(String province, String city){
        message.clear();
        if ( province != null && city != null && !province.equals("") && !city.equals("")){
            List<Scenery> sceneries = dao.getSceneryByPos(province,city);
            if ( sceneries == null || sceneries.size() == 0){
                message.setMessage(Status.NO_RESULT);
            }
            else {
                message.setMessage(Status.RETURN_OK);
                message.setResult(sceneries);
            }
        }
        else if ( city != null && !city.equals("")){
            List<Scenery> sceneries = dao.getSceneryByCity(city);
            if ( sceneries == null || sceneries.size() == 0){
                message.setMessage(Status.NO_RESULT);
            }
            else {
                message.setMessage(Status.RETURN_OK);
                message.setResult(sceneries);
            }
        }
        else {
            logger.warn("getSceneryByName: the parameter province or city is not right");
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        return message;
    }

    /**
     * 分页查询景点信息,可以只是指定城市，也可以同时指定省份和城市
     * @param province
     * @param city
     * @param start
     * @param num
     * @return
     */
    public Message getPagedSceneryByPos(String province, String city,Integer start,Integer num){
        message.clear();
        if ( start != null && num != null && province != null && city != null && !province.equals("") && !city.equals("") && start >= 0 && num > 0){
            List<Scenery> sceneries = dao.getPagedSceneryByPos(province,city,start,num);
            if ( sceneries == null || sceneries.size() == 0){
                message.setMessage(Status.NO_RESULT);
            }
            else {
                message.setMessage(Status.RETURN_OK);
                message.setResult(sceneries);
            }
        }
        else if ( city != null && !city.equals("")){
            List<Scenery> sceneries = dao.getPagedSceneryByCity(city,start,num);
            if ( sceneries == null || sceneries.size() == 0){
                message.setMessage(Status.NO_RESULT);
            }
            else {
                message.setMessage(Status.RETURN_OK);
                message.setResult(sceneries);
            }
        }
        else {
            logger.warn("getSceneryByName: the parameter province or city is not right");
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        return message;
    }


    public Message getSceneryCount(){
        message.clear();
        message.setMessage(Status.RETURN_OK);
        message.setResult(dao.getSceneryCount());
        return message;
    }

    public Message getSceneryCount(String province){
        message.clear();
        if ( province != null && !province.equals("")) {
            message.setMessage(Status.RETURN_OK);
            message.setResult(dao.getSceneryCount(province));
        }
        else {
            logger.warn("the parameter is not right");
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        return message;
    }

    public Message getSceneryCount(String province,String city){
        message.clear();
        if ( province != null && city != null && !province.equals("") && !city.equals("")) {
            message.setMessage(Status.RETURN_OK);
            message.setResult(dao.getSceneryCount(province,city));
        }
        else if ( city != null && !city.equals("")){
            message.setMessage(Status.RETURN_OK);
            message.setResult(dao.getSceneryByCity(city));
        }
        else {
            logger.warn("the parameters is not right");
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        return message;
    }

}
