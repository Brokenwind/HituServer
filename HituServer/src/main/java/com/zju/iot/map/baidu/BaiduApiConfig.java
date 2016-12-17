package com.zju.iot.map.baidu;

import com.zju.iot.map.ApiConfig;

/**
 * Created by amei on 16-12-17.
 */
public class BaiduApiConfig extends ApiConfig {
    public void initUrls() {
        this.setBaseUrl("http://api.map.baidu.com/");
        this.setDirectionUrl("http://api.map.baidu.com/direction/v2/transit");
        this.setGeocodeUrl("http://api.map.baidu.com/geocoder/v2/");
        this.setRevgeocodeUrl("http://api.map.baidu.com/geocoder/v2/");
        this.setDrivingMatrixUrl("http://api.map.baidu.com/routematrix/v2/driving");
        this.setRidingMatrixUrl("http://api.map.baidu.com/routematrix/v2/riding");
        this.setWalkingMatrixUrl("http://api.map.baidu.com/routematrix/v2/walking");
    }
}
