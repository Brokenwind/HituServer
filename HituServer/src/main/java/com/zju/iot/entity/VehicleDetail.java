package com.zju.iot.entity;

import lombok.Data;

/**
 * Created by amei on 16-12-19.
 */
@Data
public class VehicleDetail {
    /**common**/
    private String name;
    private double price;
    private String booking;
    private String departure_station;
    private String arrive_station;
    private String departure_time;
    private String arrive_time;
    /**公交相关**/
    private int type;
    private int stop_num;
    private String on_station;
    private String off_station;
    private String last_time;
    /**大巴相关**/
    private String provider_name;
    private String provider_url;
    /**飞机相关**/
    private String airlines;
    private double discount;
}
