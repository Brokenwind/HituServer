package com.zju.iot.service;

import com.zju.iot.dao.SceneryDAO;
import com.zju.iot.entity.Scenery;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by amei on 16-12-10.
 */
@Component
public class SceneryService {
    private static Logger logger = Logger.getLogger(SceneryService.class);
    @Inject
    private SceneryDAO dao;
    public Scenery getSceneryByName(String name){
        if (name != null && !name.equals(""))
            return dao.getSceneryByName(name);
        else {
            logger.warn("getSceneryByName: the parameter name is null or empty");
            return null;
        }
    }

    public Scenery getSceneryByID(String id){
        if (id != null && !id.equals(""))
            return dao.getSceneryByName(id);
        else {
            logger.warn("getSceneryByName: the parameter id is null or empty");
            return null;
        }
    }

    public ArrayList<Scenery> getSceneryByPos(String province, String city){
        if ( province != null && city != null && !province.equals("") && !city.equals("")){
            return dao.getSceneryByPos(province,city);
        }
        else {
            logger.warn("getSceneryByName: the parameter province or city is not right");
            return null;
        }
    }

    public ArrayList<Scenery> getPagedSceneryByPos(String province, String city,int start,int num){
        if ( province != null && city != null && !province.equals("") && !city.equals("") && start >= 0 && num > 0){
            return dao.getPagedSceneryByPos(province,city,start,num);
        }
        else {
            logger.warn("getSceneryByName: the parameter province or city is not right");
            return null;
        }

    }

    public long getSceneryCount(){
        return dao.getSceneryCount();
    }

    public long getSceneryCount(String province){
        if ( province != null && !province.equals("")) {
            return dao.getSceneryCount(province);
        }
        else {
            logger.warn("the parameter is not right");
            return 0;
        }
    }

    public long getSceneryCount(String province,String city){
        if ( province != null && city != null && !province.equals("") && !city.equals("")) {
            return dao.getSceneryCount(province,city);
        }
        else {
            logger.warn("the parameters is not right");
            return 0;
        }
    }

}
