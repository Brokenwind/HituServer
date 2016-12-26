package com.zju.iot.map.baidu.entity;

import com.zju.iot.entity.GeoMark;
import lombok.Data;

import java.util.ArrayList;

/**
 * Created by amei on 16-12-19.
 */
@Data
public class BaiduScheme {
    private int distance;
    private int duration;
    private String instructions;
    private String path;
    private ArrayList<BaiduTrafficCondition> traffic_condition;
    private GeoMark start_location;
    private GeoMark end_location;
    private BaiduVehicleInfo vehicle_info;
}
