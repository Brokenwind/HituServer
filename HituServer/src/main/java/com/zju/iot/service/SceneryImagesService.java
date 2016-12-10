package com.zju.iot.service;

import com.zju.iot.dao.SceneryImagesDAO;
import com.zju.iot.entity.SceneryImages;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by amei on 16-12-10.
 */
@Component
public class SceneryImagesService {
    private static Logger logger = Logger.getLogger(SceneryImagesService.class);
    @Inject
    private SceneryImagesDAO dao;
    public ArrayList<SceneryImages> getImagesBySceneryID(String sceneryID){
        if ( sceneryID != null && !sceneryID.equals(""))
            return (ArrayList<SceneryImages>) dao.getImagesBySceneryID(sceneryID);
        else{
            logger.warn("the parameter sceneryID is null or empty");
            return null;
        }
    }

    public int getImageCount(String sceneryID){
        if ( sceneryID != null && !sceneryID.equals(""))
            return dao.getImageCount(sceneryID);
        else{
            logger.warn("the parameter sceneryID is null or empty");
            return 0;
        }
    }
}
