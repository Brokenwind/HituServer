package com.zju.iot.map.baidu;

import com.zju.iot.common.ServiceProvider;
import com.zju.iot.common.http.HttpUtil;
import com.zju.iot.common.http.Result;
import com.zju.iot.entity.Direction;
import com.zju.iot.entity.GeoMark;
import com.zju.iot.map.ApiConfig;
import com.zju.iot.map.ApiFactory;
import com.zju.iot.map.MapService;
import org.apache.http.client.ClientProtocolException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by amei on 16-12-19.
 */

public class Baidu implements MapService {
    private ApiConfig baiduApi = ApiFactory.getApiConfig(ServiceProvider.BAIDU_API);

    public Direction getDirection(GeoMark origin,GeoMark destination){
        Map<String, String> params = new HashMap<String, String>();
        params.put("origin", origin.toString());
        params.put("destination", destination.toString());
        params.put("ak","sh0wDYRg1LnB5OYTefZcuHu3zwuoFeOy");
        String result = "";
        try {
            Result r = HttpUtil.get(baiduApi.getDirectionUrl(), null, params);
            result = r.getBody();
            HttpUtil.closeClient(r.getHttpClient());
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DirectionAdapter.getDirection(result);
    }

    public String test(){
        String login_url = "http://api.map.baidu.com/geocoder/v2/";
        Map<String, String> params = new HashMap<String, String>();
        params.put("location", "39.983424,116.322987");
        params.put("output", "json");
        params.put("pois", "1");
        params.put("ak","sh0wDYRg1LnB5OYTefZcuHu3zwuoFeOy");
        String result = null;
        try {
            Result r = HttpUtil.post(login_url, null, params, "UTF-8");
            result = r.getBody();
            HttpUtil.closeClient(r.getHttpClient());
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
