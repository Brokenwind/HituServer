package com.zju.iot.dao;

import com.zju.iot.entity.UserTrace;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amei on 16-12-26.
 */
@Component
public class UserTraceDAO {
    @Inject
    private BaseDAO baseDAO;

    public boolean addUserTrace(UserTrace trace){
        return baseDAO.save(trace);
    }

    public boolean updateUserTrace(UserTrace trace){
        return baseDAO.update(trace);
    }

    public UserTrace getUserTraceByTraceID(String userID, String traceID){
        if ( userID != null && traceID != null ) {
            String hsql = "from UserTrace trace where trace.userID = ? and trace.traceID = ?";
            ArrayList<String> params = new ArrayList<String>();
            params.add(userID);
            params.add(traceID);
            return (UserTrace) baseDAO.uniqueResult(hsql, params);
        }
        else
            return null;
    }

    public UserTrace latestUserTrace(String userID){
        if ( userID != null) {
            String hsql = "from UserTrace trace where trace.userID = ? order by trace.date desc";
            ArrayList<String> params = new ArrayList<String>();
            params.add(userID);
            List list =  baseDAO.getPagedList(hsql,params,0,1);
            if ( list != null)
                return (UserTrace) list.get(0);
            else
                return null;
        }
        else
            return null;
    }

    /**
     * 获取所有踪迹
     * @param userID
     * @return
     */
    public ArrayList<UserTrace> getTraces(String userID){
        if ( userID != null) {
            String hsql = "from UserTrace trace where trace.userID = ? order by trace.date desc";
            ArrayList<String> params = new ArrayList<String>();
            params.add(userID);
            return (ArrayList<UserTrace>) baseDAO.getList(hsql,params);
        }
        else
            return null;
    }

}
