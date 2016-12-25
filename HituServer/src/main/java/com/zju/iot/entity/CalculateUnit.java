package com.zju.iot.entity;

import lombok.Data;

/**
 * Created by amei on 16-12-25.
 */
@Data
public class CalculateUnit {
    private int openTime;
    private int closeTime;
    private GeoMark mark;
    private int stayTime;
    private float price;
    private int level;
}
