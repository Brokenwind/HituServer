package com.zju.iot.common;

/**
 * Created by amei on 16-12-17.
 * 地图服务由谁提供
 */
public enum ServiceProvider {
    /**默认情况下是百度地图API**/
    NONE(0,"Baidu"),
    /**百度地图API**/
    BAIDU_API(1,"Baidu"),
    /**Google地图API**/
    GOOGLE_API(2,"Google"),
    /**高德地图API**/
    AMAP(3,"Amap");
    private final String name;
    private final int id;
    private ServiceProvider(int id, String name){
        this.id = id;
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
