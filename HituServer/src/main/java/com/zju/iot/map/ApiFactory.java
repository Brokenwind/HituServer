package com.zju.iot.map;

import com.zju.iot.common.ServiceProvider;
import org.apache.log4j.Logger;

/**
 * Created by amei on 16-12-17.
 * it is responsible for creating relative ApiConfig objects of kinds of maps
 */
public class ApiFactory {
    private static Logger logger = Logger.getLogger(ApiConfig.class);
    /***
     * create relative ApiConfig object according to the parameter you passed
     * @param provider
     * @return
     */
    public static synchronized ApiConfig getApiConfig(ServiceProvider provider){
        String current = provider.getName();
        String packageName = ApiFactory.class.getPackage().getName();
        packageName += "."+current.toLowerCase()+"."+current+"ApiConfig";
        ApiConfig baseApi = null;
        try {
            Class<?> class1 = Class.forName(packageName);
            baseApi = (ApiConfig) class1.newInstance();
        }catch (Exception e){
            logger.error("can't create object,please check your package name");
        }
        return baseApi;
    }
}
