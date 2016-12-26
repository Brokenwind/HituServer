package com.zju.iot.map.baidu.entity;

import lombok.Data;

/**
 * Created by amei on 16-12-19.
 */
@Data
public class BaiduVehicleInfo {
    private int type;
    private BaiduVehicleDetail detail;
}
