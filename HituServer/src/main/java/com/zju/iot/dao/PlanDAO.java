package com.zju.iot.dao;

import com.zju.iot.entity.Plan;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amei on 16-12-26.
 */
@Component
public class PlanDAO {
    @Inject
    private BaseDAO baseDAO;

    public boolean addPlan(Plan plan){
        return baseDAO.save(plan);
    }

    public Plan getPlanByPlanID(String userID, String planID){
        if ( userID != null && planID != null ) {
            String hsql = "from Plan plan where plan.userID = ? and plan.planID = ?";
            ArrayList<String> params = new ArrayList<String>();
            params.add(userID);
            params.add(planID);
            return (Plan) baseDAO.uniqueResult(hsql, params);
        }
        else
            return null;
    }

    public Plan latestUncommitedPlan(String userID){
        if ( userID != null) {
            String hsql = "from Plan plan where plan.userID = ? and plan.isCommit = ? order by plan.createTime desc";
            ArrayList<String> params = new ArrayList<String>();
            params.add(userID);
            params.add(String.valueOf(0));
            List list =  baseDAO.getPagedList(hsql,params,0,1);
            if ( list != null)
                return (Plan) list.get(0);
            else
                return null;
        }
        else
            return null;
    }

}
