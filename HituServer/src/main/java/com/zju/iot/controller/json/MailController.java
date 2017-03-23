package com.zju.iot.controller.json;

import com.zju.iot.service.MailService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

/**
 * Created by amei on 17-3-22.
 */
@Controller
@RequestMapping("/mail")
public class MailController {
    private static Logger logger = Logger.getLogger(MailController.class);
    @Inject
    private MailService mailService;

    @RequestMapping("/send")
    @ResponseBody
    public String addPlan(){
        mailService.sendHtmlMail("password reset","<a href='http://www.baidu.com'>baidu</a>","wangkun6536@163.com");
        return "it is a mail";
    }

}
