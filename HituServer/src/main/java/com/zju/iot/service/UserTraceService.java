package com.zju.iot.service;

import com.zju.iot.common.Message;
import com.zju.iot.common.Status;
import com.zju.iot.dao.UserDAO;
import com.zju.iot.dao.UserTraceDAO;
import com.zju.iot.entity.GeoMark;
import com.zju.iot.entity.UserTrace;
import com.zju.iot.map.baidu.Baidu;
import com.zju.iot.map.baidu.entity.BaiduRevGeoCode;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by amei on 16-12-27.
 */
@Component
public class UserTraceService {
    @Inject
    private UserTraceDAO traceDAO;
    @Inject
    private UserDAO userDAO;
    @Inject
    private Baidu map;

    private Message message = new Message();

    /**
     * if successfully add the trace, it will return traceID for further use;
     * @return
     */
    public Message addUserTrace(String userID,Double lng, Double lat ){
        message.clear();
        UserTrace trace = new UserTrace();
        if ( userID == null || lng == null || lat == null )
            message.setMessage(Status.ILLEGAL_PARAMS);
        else {
            trace.setUserID(userID);
            trace.setLongitude(lng);
            trace.setLatitude(lat);
            // is the user existed
            if ( userDAO.isUserExistByID(userID) ) {
                trace.setTraceID(UUID.randomUUID().toString());
                trace.setDate(System.currentTimeMillis());
                BaiduRevGeoCode ret = map.getRevGeoCode(new GeoMark("",lng,lat));
                if ( ret != null && ret.getAddressComponent() != null){
                    trace.setAddress(ret.getFormatted_address());
                    trace.setProvince(ret.getAddressComponent().getProvince());
                    trace.setCity(ret.getAddressComponent().getCity());
                    trace.setDistrict(ret.getAddressComponent().getDistrict());
                    trace.setStreet(ret.getAddressComponent().getStreet());
                }
                if (traceDAO.addUserTrace(trace)) {
                    message.setMessage(Status.RETURN_OK);
                    message.setResult(trace.getUserID());
                } else
                    message.setMessage(Status.INNER_ERROR);
            }
            else
                message.setMessage(Status.NO_RESULT);
        }
        return message;
    }


    public Message getTraces(String userID){
        message.clear();
        if ( userID != null ){
            ArrayList<UserTrace> traces = traceDAO.getTraces(userID);
            if ( traces != null ){
                message.setMessage(Status.RETURN_OK);
                message.setResult(traces);
            }
            else
                message.setMessage(Status.NO_RESULT);
        }
        else {
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        return message;
    }

}
