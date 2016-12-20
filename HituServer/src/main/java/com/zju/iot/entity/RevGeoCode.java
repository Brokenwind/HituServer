package com.zju.iot.entity;

import lombok.Data;

import java.util.ArrayList;

/**
 * Created by amei on 16-12-20.
 * 逆地理编码
 */
@Data
public class RevGeoCode {
    /**longitude and latitude**/
    private GeoMark location;
    /**结构化地址信息**/
    private String formatted_address;
    /**所在商圈信息，如 "人民大学,中关村,苏州街"**/
    private String business;
    private Address addressComponent;
    /**周边poi数组**/
    private ArrayList<Poi> pois;
    /**当前位置结合POI的语义化结果描述**/
    private String sematic_description;
}
