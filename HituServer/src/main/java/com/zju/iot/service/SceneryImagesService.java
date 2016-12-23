package com.zju.iot.service;

import com.zju.iot.common.Message;
import com.zju.iot.common.Status;
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
    private Message message = new Message();
    @Inject
    private SceneryImagesDAO dao;
    public Message getImagesBySceneryID(String sceneryID){
        message.clear();
        if ( sceneryID != null && !sceneryID.equals("")){
            ArrayList<SceneryImages> images = dao.getImagesBySceneryID(sceneryID);
            if (images != null){
                message.setMessage(Status.RETURN_OK);
                message.setResult(images);
            }
            else {
                message.setMessage(Status.NO_RESULT);
            }
        }
        else{
            logger.warn("the parameter sceneryID is null or empty");
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        return  message;
    }

    public Message getImageCount(String sceneryID){
        message.clear();
        if ( sceneryID != null && !sceneryID.equals("")) {
            message.setMessage(Status.RETURN_OK);
            message.setResult(dao.getImageCount(sceneryID));
        }
        else{
            logger.warn("the parameter sceneryID is null or empty");
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        return message;
    }
}
