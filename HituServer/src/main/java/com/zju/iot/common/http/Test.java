package com.zju.iot.common.http;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.cookie.Cookie;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by amei on 16-12-19.
 */
public class Test {
    public static void main(String[] args) {
        String login_url = "http://api.map.baidu.com/geocoder/v2/";
        Map<String, String> params = new HashMap<String, String>();
        params.put("location", "39.983424,116.322987");
        params.put("output", "json");
        params.put("pois", "1");
        params.put("ak","sh0wDYRg1LnB5OYTefZcuHu3zwuoFeOy");
        try {
            Result r = HttpUtil.post(login_url, null, params, "UTF-8");
            for(Cookie cookie : r.getCookies()){
                System.out.println(cookie.getName() + "=" + cookie.getValue());
            }
            System.out.println(r.getBody());
            HttpUtil.closeClient(r.getHttpClient());
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
