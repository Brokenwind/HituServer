package com.zju.iot.service;

import com.zju.iot.controller.json.MailController;
import org.apache.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by amei on 17-3-22.
 */
@Component
public class MailService {
    @Inject
    private JavaMailSenderImpl sender;
    private static Logger logger = Logger.getLogger(MailController.class);

    public void sendHtmlMail(String title,String content,String dest){
        //构建邮件
        MimeMessage message=sender.createMimeMessage();
        try {
            //使用MimeMessageHelper构建Mime类型邮件
            MimeMessageHelper helper= new MimeMessageHelper(message,true);
            helper.setFrom("amei6536@163.com");
            helper.setTo(dest);
            message.setSubject(title);
            //第二个参数true表明信息类型是multipart类型
            helper.setText(content,true);
            sender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("邮件构造失败");
        }
    }
}
