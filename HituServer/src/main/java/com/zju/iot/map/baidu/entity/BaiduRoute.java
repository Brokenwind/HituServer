package com.zju.iot.map.baidu.entity;

import lombok.Data;

import java.util.ArrayList;

/**
 * Created by amei on 16-12-19.
 */
@Data
public class BaiduRoute {
    private int distance;
    private int duration;
    private String arrive_time;
    private double price;
    private ArrayList<ArrayList<BaiduScheme>> steps;
}
