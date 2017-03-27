package com.zju.iot.controller.web;

import com.zju.iot.common.Message;
import com.zju.iot.common.Status;
import com.zju.iot.common.utils.EncryptUtil;
import com.zju.iot.entity.User;
import com.zju.iot.service.MailService;
import com.zju.iot.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

/**
 * operate the
 */
@Controller
@RequestMapping("/user")
public class LoginController {
    private static Logger logger = Logger.getLogger(LoginController.class);
    @Inject
    private UserService userService;
    @Inject
    private MailService mailService;

    @RequestMapping(value = "/i_forget_password")
    @ResponseBody
    public Message forgetPass(HttpServletRequest request, String nickname){
        Message map = new Message();
        Message usermsg = userService.getUser(nickname);
        if ( ! usermsg.isSuccess() ){
            map.setMessage(Status.USER_NOT_EXISTED);
            return map;
        }
        User user = (User) usermsg.getResult();
        try{
            String secretKey= UUID.randomUUID().toString();  //密钥
            long outDate = System.currentTimeMillis()+30*60*1000 ;//30分钟后过期
            user.setValidataCode(secretKey);
            user.setExpierTime(outDate);
            userService.updateUser(user);    //保存到数据库
            String key = user.getNickname()+"$"+outDate+"$"+secretKey;
            String digitalSignature = EncryptUtil.getMD5(key);               //数字签名
            String emailTitle = "Hitu密码找回";
            String path = request.getContextPath();
            String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
            String resetPassHref =  basePath+"user/reset_password?sid="+digitalSignature+"&nickname="+user.getNickname();
            String emailContent = "请勿回复本邮件.点击下面的链接,重设密码<br/><a href="+resetPassHref +" target='_BLANK'>点击我重新设置密码</a>" +
                    "<br/>tips:本邮件超过30分钟,链接将会失效，需要重新申请'找回密码'"+key+"\t"+digitalSignature;
            System.out.print(resetPassHref);
           mailService.sendHtmlMail(emailTitle,emailContent,user.getEmail());
            map.setMessage(Status.RETURN_OK);
        }catch (Exception e){
            e.printStackTrace();
            map.setMessage(Status.WRONG_MAIL);
        }
        return map;
    }

    @RequestMapping(value = "/reset_password",method = RequestMethod.GET)
    public String checkResetLink(Map<String,Object> model, String sid, String nickname){
        String turnUrl = "turn";
        // the message passed to the client to
        String msg = "";
        // if the result of check is correct, refer to this url
        String sucessUrl = "/HituServer/user/reset?nickname="+nickname;
        // if the result of check is failed, refer to this url
        String failedUrl = "/HituServer/views/login.jsp";
        logger.info("sid: "+sid+"nickname "+nickname);
        if( sid == null || nickname == null || sid.equals("") || nickname.equals("")){
            msg="链接不完整,请重新生成";
            model.put("status",1) ;
            model.put("msg",msg) ;
            model.put("url",failedUrl) ;
            logger.info(msg);
            return turnUrl;
        }
        Message usermsg = userService.getUser(nickname);
        if(!usermsg.isSuccess()){
            msg = "链接错误,无法找到匹配用户,请重新申请找回密码.";
            model.put("status",2) ;
            model.put("msg",msg) ;
            model.put("url",failedUrl) ;
            logger.info(msg);
            return turnUrl;
        }
        User user = (User) usermsg.getResult();
        long outDate = user.getExpierTime();
        if(outDate <= System.currentTimeMillis()){         //表示已经过期
            msg = "链接已经过期,请重新申请找回密码.";
            model.put("status",3) ;
            model.put("msg",msg) ;
            model.put("url",failedUrl) ;
            logger.info(msg);
            return turnUrl;
        }
        String key = user.getNickname()+"$"+outDate+"$"+user.getValidataCode();          //数字签名
        String digitalSignature = EncryptUtil.getMD5(key);
        logger.info(key+"\t"+digitalSignature);
        if(!digitalSignature.equals(sid)) {
            msg = "链接不正确,是否已经过期了?重新申请吧";
            model.put("status",4) ;
            model.put("msg",msg);
            model.put("url",failedUrl) ;
            logger.info(msg);
            return turnUrl;
        }
        // pass the authentication
        model.put("status",0) ;
        model.put("msg","你通过验证");
        model.put("url",sucessUrl) ;
        return turnUrl;
    }

    @RequestMapping(value = "/commit_password")
    @ResponseBody
    public Message forgetPass(String nickname,String password) {
        return userService.resetPassword(nickname,password);
    }

    @RequestMapping(value = "/reset")
    public String  reset(Map<String,Object> model,String nickname) {
        model.put("nickname",nickname);
        return "reset";
    }

    @RequestMapping(value = "/loginpage")
    public String  login() {
        return "login";
    }
}
