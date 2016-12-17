package com.zju.iot.map;

import lombok.Data;

/**
 * Created by amei on 16-12-17.
 * The base class of map api.All the map api classes must extends this class
 */
@Data
public abstract class ApiConfig {
    public ApiConfig(){initUrls();}
    public void initUrls(){}
    /**所有api的前缀**/
    private String baseUrl;
    /**路线规划API接口**/
    private String directionUrl;
    /**从地址到经纬度坐标的转换**/
    private String geocodeUrl;
    /**从经纬度坐标到地址的转换**/
    private String revgeocodeUrl;
    /**驾车批量算路接口，返回路线规划距离和行驶时间**/
    private String drivingMatrixUrl;
    /**骑行批量算路接口，返回路线规划距离和行驶时间**/
    private String ridingMatrixUrl;
    /**步行批量算路接口，返回路线规划距离和行驶时间**/
    private String walkingMatrixUrl;
    /**初始化api地址**/

}
