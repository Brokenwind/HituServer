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

    public boolean addSelectedPoint(SelectedPoint point){
        return baseDAO.save(point);
    }

    public boolean deleteSelectedPoint(SelectedPoint point){
        return baseDAO.delete(point);
    }

    public boolean batchSelectedPoint(List objects){
        return baseDAO.batchSave(objects);
    }

    /**
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

    /**
     * get a single specified SelectedPoint
     * @param planID
     * @param selectedID
     * @return
     */
    public SelectedPoint getSelectedPoint(String planID,String selectedID){
        if ( planID != null && selectedID != null) {
            String hsql = "from SelectedPoint point where point.planID = ? and point.selectedID = ?";
            ArrayList<String> params = new ArrayList<String>();
            params.add(planID);
            params.add(selectedID);
            return (SelectedPoint) baseDAO.uniqueResult(hsql, params);
        }
        else
            return null;
    }

}
