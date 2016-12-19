package com.zju.iot.entity;

import lombok.Data;

/**
 * Created by amei on 16-12-19.
 */
@Data
public class TaxiDetail {
    private String desc;
    private double km_price;
    private double start_price;
    private double total_price;
}
