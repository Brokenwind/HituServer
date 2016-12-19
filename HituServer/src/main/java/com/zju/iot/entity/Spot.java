package com.zju.iot.entity;

import lombok.Data;

/**
 * Created by amei on 16-12-19.
 */
@Data
public class Spot {
    private String city_id;
    private String city_name;
    private GeoMark location;
}
