package com.zju.iot.service;

import com.zju.iot.common.Message;
import com.zju.iot.common.Status;
import com.zju.iot.dao.CityImagesDAO;
import com.zju.iot.entity.CityImages;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by amei on 16-12-10.
 */
@Component
public class CityImagesService {
    private static Logger logger = Logger.getLogger(CityImagesService.class);
    private Message message = new Message();
    @Inject
    private CityImagesDAO dao;
    public Message getImagesByCityID(String cityID){
        message.clear();
        if ( cityID != null && !cityID.equals("")){
            ArrayList<CityImages> images = dao.getImagesByCityID(cityID);
            if (images != null){
                message.setMessage(Status.RETURN_OK);
                message.setResult(images);
            }
            else {
                message.setMessage(Status.NO_RESULT);
            }
        }
        else{
            logger.warn("the parameter cityID is null or empty");
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        return  message;
    }

    public Message getImageCount(String cityID){
        message.clear();
        if ( cityID != null && !cityID.equals("")) {
            message.setMessage(Status.RETURN_OK);
            message.setResult(dao.getImageCount(cityID));
        }
        else{
            logger.warn("the parameter cityID is null or empty");
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        return message;
    }
}
