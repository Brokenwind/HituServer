package com.zju.iot.map.baidu;

import com.zju.iot.common.ServiceProvider;
import com.zju.iot.common.http.HttpUtil;
import com.zju.iot.common.http.Result;
import com.zju.iot.entity.*;
import com.zju.iot.map.ApiConfig;
import com.zju.iot.map.ApiFactory;
import com.zju.iot.map.MapService;
import org.apache.http.client.ClientProtocolException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
        return DirectionAdapter.parseDirection(result);
    }

    /**
     * 地理编码服务
     * @param address 根据指定地址进行坐标的反定向解析，最多支持100个字节输入。
    可以输入三种样式的值，分别是：
    1、标准的地址信息，如北京市海淀区上地十街十号
    2、名胜古迹、标志性建筑物，如天安门，百度大厦
    3、支持“*路与*路交叉口”描述方式，如北一环路和阜阳路的交叉路口
    注意：后两种方式并不总是有返回结果，只有当地址库中存在该地址描述时才有返回。
     * @param city 地址所在的城市名。用于指定上述地址所在的城市，当多个城市都有上述地址时，该参数起到过滤作用。
     * @return
     */
    public GeoCode getGeoCode(String address, String city) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("address",address );
        params.put("city", city);
        params.put("output","json");
        params.put("ak","sh0wDYRg1LnB5OYTefZcuHu3zwuoFeOy");
        String result = "";
        try {
            Result r = HttpUtil.get(baiduApi.getGeocodeUrl(), null, params);
            result = r.getBody();
            HttpUtil.closeClient(r.getHttpClient());
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return GeoCodeAdapter.parseGeoCode(result);

    }

    /**
     * 根据经纬度坐标获取地址
     * @param geoMark
     * @return
     */
    public RevGeoCode getRevGeoCode(GeoMark geoMark) {
        Map<String, String> params = new HashMap<String, String>();
        /**
         * 38.76623,116.43213 lat<纬度>,lng<经度>
         */
        params.put("location",geoMark.toString() );
        params.put("output","json");
        params.put("ak","sh0wDYRg1LnB5OYTefZcuHu3zwuoFeOy");
        String result = "";
        try {
            Result r = HttpUtil.get(baiduApi.getGeocodeUrl(), null, params);
            result = r.getBody();
            HttpUtil.closeClient(r.getHttpClient());
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return GeoCodeAdapter.parseRevGeoCode(result);
    }

    /**
     * 提供的批量算路接口，返回路线规划距离和行驶时间。
     * @param origins
     * @param destinations
     * @return
     */
    public RouteMatrix getRouteMatrix(List<GeoMark> origins,List<GeoMark> destinations){
        if (origins == null || destinations == null || origins.size() == 0 || destinations.size() == 0)
            return null;
        String originstr = origins.get(0).toString();
        String deststr = destinations.get(0).toString();
        for (int i = 1; i < origins.size(); i++)
            originstr = originstr + "|"+origins.get(i);
        for (int i = 1; i < destinations.size(); i++)
            deststr = deststr + "|"+destinations.get(i);
        Map<String, String> params = new HashMap<String, String>();
        params.put("origins",originstr);
        params.put("destinations",deststr);
        params.put("output","json");
        params.put("ak","sh0wDYRg1LnB5OYTefZcuHu3zwuoFeOy");
        String result = "";
        try {
            Result r = HttpUtil.get(baiduApi.getDrivingMatrixUrl(), null, params);
            result = r.getBody();
            HttpUtil.closeClient(r.getHttpClient());
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return MatrixAdapter.getRouteMatrix(result);
    }


}
