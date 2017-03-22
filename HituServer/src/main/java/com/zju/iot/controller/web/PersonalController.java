package com.zju.iot.controller.web;

import com.zju.iot.common.Message;
import com.zju.iot.common.utils.DateTimeUtil;
import com.zju.iot.controller.entity.PlanLine;
import com.zju.iot.entity.Plan;
import com.zju.iot.entity.SelectedPoint;
import com.zju.iot.entity.UserTrace;
import com.zju.iot.service.PlanService;
import com.zju.iot.service.SelectedPointService;
import com.zju.iot.service.UserService;
import com.zju.iot.service.UserTraceService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Created by amei on 17-1-6.
 */
@Controller
@RequestMapping("/")
public class PersonalController {
    private static Logger logger = Logger.getLogger(PersonalController.class);
    @Inject
    private UserService userService;
    @Inject
    private PlanService planService;
    @Inject
    private SelectedPointService pointService;
    @Inject
    private UserTraceService traceService;
    @RequestMapping("personal")
    public String personal(Map<String,Object> model, String userID){
        // put user information
        Message user = userService.getUserByID(userID);
        if ( user.isSuccess() ) {
            model.put("user", user.getResult());
        }
        // put plan timeline information
        ArrayList<PlanLine> planLines = new ArrayList<PlanLine>();
        Message msgplan = planService.getCommitPlans(userID);
        if ( msgplan.isSuccess() ){
            ArrayList<Plan> plans = (ArrayList<Plan>) msgplan.getResult();
            for ( Plan plan : plans ) {
                PlanLine line = new PlanLine();
                String content = "";
                ArrayList<SelectedPoint> points = pointService.getPointsByPlanID(plan.getPlanID());
                for ( SelectedPoint point : points ){
                    content = content+point.getName()+"\n";
                }
                line.setCity(plan.getCity());
                line.setTime(DateTimeUtil.getLongFormat(new Date(plan.getCommitTime())));
                line.setContent(content);
                planLines.add(line);
            }
        }
        model.put("planline", planLines);
        // put trace timeline information
        ArrayList<UserTrace> traces = new ArrayList<UserTrace>();
        Message msgtrace = traceService.getTraces(userID);
        if ( msgtrace.isSuccess() ){
            traces = (ArrayList<UserTrace>) msgtrace.getResult();
            for (UserTrace trace: traces)
                trace.setStrdate(DateTimeUtil.getLongFormat(new Date(trace.getDate())));
        }
        model.put("traces", traces);
        return "personal";
    }
}
