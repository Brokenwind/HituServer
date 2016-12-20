package com.zju.iot.entity;

import lombok.Data;

/**
 * Created by amei on 16-12-20.
 */
@Data
public class Address {
    private String country;
    private String province;
    private String city;
    /**区县名**/
    private String district;
    private String street;
    private String street_number;
    /**行政区划代码**/
    private String adcode;
    /**和当前坐标点的方向，当有门牌号的时候返回数据 **/
    private String direction;
    /**和当前坐标点的距离，当有门牌号的时候返回数据 **/
    private String distance;
}
