package com.zju.iot.entity;

import lombok.Data;

/**
 * Created by amei on 16-12-20.
 */
@Data
public class GeoCode {
    private GeoMark location;
    private int precise;
    private int confidence;
    private String level;
}
