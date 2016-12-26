package com.zju.iot.dao;

import com.zju.iot.entity.Scheme;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amei on 16-12-26.
 */
@Component
public class SchemeDAO {
    @Inject
    private BaseDAO baseDAO;

    public boolean addScheme(Scheme scheme){
        return baseDAO.save(scheme);
    }

    /**
     *  批量插入
     * @param schemes
     * @return
     */
    public boolean batchAddScheme(List schemes){
        return baseDAO.batchSave(schemes);
    }

    public ArrayList<Scheme> getSchemesByRouteID(String routeID){
        if (routeID != null)
        {
            String hsql="from Scheme scheme where scheme.routeID = ?";
            ArrayList<String> params = new ArrayList<String>();
            params.add(routeID);
            return (ArrayList<Scheme>) baseDAO.getList(hsql,params);
        }
        else
            return null;
    }
}
