package com.zju.iot.service;

import com.zju.iot.common.Message;
import com.zju.iot.common.Status;
import com.zju.iot.common.utils.DateTimeUtil;
import com.zju.iot.dao.SelectedPointDAO;
import com.zju.iot.entity.SelectedPoint;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by amei on 16-12-27.
 */
@Component
public class SelectedPointService {
    @Inject
    private SelectedPointDAO selectedPointDAO;
    private Message message = new Message();

    /**
     * add calculation point
     * @param planID
     * @param lng
     * @param lat
     * @param openTime  it needs to convert hh:mm to minutes
     * @param closeTime it needs to convert  hh:mm to minutes
     * @param stayTime
     * @param price not necessary
     * @param level it needs to convert %dA to %d
     * @return
     */
    public Message addSelectedPoint(String planID,Double lng, Double lat, String openTime, String closeTime, Integer stayTime,String level, Double price ){
        message.clear();

        if (planID == null || lng == null|| lat == null || openTime == null || closeTime == null|| stayTime == null){
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        else {

            int lev = 0;
            if (level != null || !level.equals("")){
                lev = level.charAt(0) - '0';
            }
            if (price == null)
                price = new Double(0.0);

            SelectedPoint point = new SelectedPoint(planID,UUID.randomUUID().toString(),lng,lat, DateTimeUtil.converToMinutes(openTime),DateTimeUtil.converToMinutes(closeTime),stayTime,lev,price);
            if (selectedPointDAO.addSelectedPoint(point)){
                message.setMessage(Status.RETURN_OK);
            }
            else
                message.setMessage(Status.INNER_ERROR);
        }
        return message;
    }

    public Message deleteSelectedPoint(String planID,String selectedID){
        message.clear();
        if ( planID == null || selectedID == null )
            message.setMessage(Status.ILLEGAL_PARAMS);
        else {
            SelectedPoint point = selectedPointDAO.getSelectedPoint(planID,selectedID);
            if ( point == null )
                message.setMessage(Status.NO_RESULT);
            else {
                if (selectedPointDAO.deleteSelectedPoint(point))
                    message.setMessage(Status.RETURN_OK);
                else
                    message.setMessage(Status.DELETE_FAILED);
            }
        }
        return  message;
    }

    public Message getSelectedPointsByPlanID(String planID){
        message.clear();
        if ( planID == null ){
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        else {
            ArrayList<SelectedPoint> points = selectedPointDAO.getSelectedPointsByPlanID(planID);
            if ( points == null || points.size() == 0 )
                message.setMessage(Status.NO_RESULT);
            else {
                message.setMessage(Status.RETURN_OK);
                message.setResult(points);
            }
        }
        return message;
    }

    /**
     * the function is same as getSelectedPointByPlanID,but it is for inner use
     * @param planID
     * @return
     */
    public ArrayList<SelectedPoint> getPointsByPlanID(String planID){
        if ( planID == null ){
            return null;
        }
        else {
            ArrayList<SelectedPoint> points = selectedPointDAO.getSelectedPointsByPlanID(planID);
            return  points;
        }
    }

}
