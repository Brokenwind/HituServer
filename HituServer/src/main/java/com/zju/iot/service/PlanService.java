package com.zju.iot.service;

import com.zju.iot.common.Message;
import com.zju.iot.common.Status;
import com.zju.iot.dao.PlanDAO;
import com.zju.iot.dao.UserDAO;
import com.zju.iot.entity.Plan;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.UUID;

/**
 * Created by amei on 16-12-27.
 */
@Component
public class PlanService {
    @Inject
    private PlanDAO planDAO;
    @Inject
    private UserDAO userDAO;

    private Message message = new Message();

    /**
     * if successfully add the plan, it will return planID for further use;
     * @param plan
     * @return
     */
    public Message addPlan(Plan plan){
        message.clear();
        if (plan == null || plan.getUserID() == null || plan.getPlanlng() == null || plan.getPlanlat() == null)
            message.setMessage(Status.ILLEGAL_PARAMS);
        else {
            if (userDAO.isUserExistByID(plan.getUserID())) {
                plan.setPlanID(UUID.randomUUID().toString());
                plan.setCreateTime(System.currentTimeMillis());
                plan.setIsCommit(0);
                if (planDAO.addPlan(plan)){
                    message.setMessage(Status.RETURN_OK);
                    message.setResult(plan.getPlanID());
                }
                else{
                    message.setMessage(Status.INNER_ERROR);
                }
            }
            else {
                message.setMessage(Status.USER_NOT_EXISTED);
            }
        }
        return message;
    }

    /**
     * commit the plan，and programme the plan
     * @param userID
     * @param planID
     * @return the sequence of routes you will trival along with it
     */
    public Message commintPlan(String userID,String planID){
        message.clear();
        if ( userID != null && planID != null){
            Plan plan = planDAO.getPlanByPlanID(userID,planID);
            if ( plan == null ){
                message.setMessage(Status.NO_RESULT);
            }
            else{
                plan.setIsCommit(1);
                plan.setCommitTime(System.currentTimeMillis());
                if ( planDAO.updatePlan(plan) ) {
                    message.setMessage(Status.RETURN_OK);
                    message.setResult(plan);
                }
                else
                    message.setMessage(Status.UPDATE_FAILED);
            }
        }
        else {
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        return  message;
    }

    public Message getPlanByPlanID(String userID, String planID){
        message.clear();
        if ( userID != null && planID != null){
            Plan plan = planDAO.getPlanByPlanID(userID,planID);
            if ( plan == null ){
                message.setMessage(Status.NO_RESULT);
            }
            else{
                message.setMessage(Status.RETURN_OK);
                message.setResult(plan);
            }
        }
        else {
            message.setMessage(Status.ILLEGAL_PARAMS);
        }
        return  message;
    }

    public Message latestUncommitedPlan(String userID){
        message.clear();
        if ( userID != null ){
            Plan plan = planDAO.latestUncommitedPlan(userID);
            if ( plan != null ){
                message.setMessage(Status.RETURN_OK);
                message.setResult(plan);
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
