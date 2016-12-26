package com.zju.iot.map.baidu.entity;

import lombok.Data;

import java.util.ArrayList;

/**
 * Created by amei on 16-12-19.
 */
@Data
public class BaiduDirection {
    private BaiduSpot origin;
    private BaiduSpot destination;
    private BaiduTaxi taxi;
    private int total;
    private ArrayList<BaiduRoute> routes;
}
