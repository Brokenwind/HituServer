package com.zju.iot.dao;

import com.zju.iot.entity.SelectedPoint;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amei on 16-12-26.
 */
@Component
public class SelectedPointDAO {
    @Inject
    private BaseDAO baseDAO;

    public boolean addSelectedPoint(Object object){
        return baseDAO.save(object);
    }

    public boolean batchSelectedPoint(List objects){
        return baseDAO.batchSave(objects);
    }

    /**
     *
     * @param planID
     * @return
     */
    public ArrayList<SelectedPoint> getSelectedPointsByPlanID(String planID){
        if ( planID != null ) {
            String hsql = "from SelectedPoint point where point.planID = ?";
            ArrayList<String> params = new ArrayList<String>();
            params.add(planID);
            return (ArrayList<SelectedPoint>) baseDAO.getList(hsql, params);
        }
        else
            return null;
    }

}
