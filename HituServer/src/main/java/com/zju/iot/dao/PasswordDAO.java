package com.zju.iot.dao;

import com.zju.iot.common.Constants;
import com.zju.iot.entity.Password;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by amei on 16-12-11.
 */
@Component
public class PasswordDAO {
    @Inject
    private BaseDAO baseDAO;

    public boolean addPassword(Password pd){
        return baseDAO.save(pd);
    }

    public Password getPassword(int type,String account){
        String typename = "nickname";
        if(type == Constants.LOGIN_TYPE_NICKNAME)
            typename = "nickname";
        if(type == Constants.LOGIN_TYPE_PHONE)
            typename = "phone";
        if (type == Constants.LOGIN_TYPE_EMAIL)
            typename = "email";
        String hsql = "from Password password where password."+typename+" = ?";
        return (Password) baseDAO.uniqueResult(hsql,account);
    }
}
