package com.zju.iot.map.baidu.entity;

import lombok.Data;

/**
 * Created by amei on 16-12-19.
 */
@Data
public class BaiduTaxiDetail {
    private String desc;
    private double km_price;
    private double start_price;
    private double total_price;
}
