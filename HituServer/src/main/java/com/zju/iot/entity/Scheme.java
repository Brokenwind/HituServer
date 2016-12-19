package com.zju.iot.entity;

import lombok.Data;

import java.util.ArrayList;

/**
 * Created by amei on 16-12-19.
 */
@Data
public class Scheme {
    private int distance;
    private int duration;
    private String instructions;
    private String path;
    private ArrayList<TrafficCondition> traffic_condition;
    private GeoMark start_location;
    private GeoMark end_location;
}
