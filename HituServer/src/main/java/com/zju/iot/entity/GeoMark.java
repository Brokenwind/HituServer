package com.zju.iot.entity;

import lombok.Data;

/**
 * Created by amei on 16-12-19.
 */
@Data
public class GeoMark {
    private double lng;
    private double lat;
    public String toString(){
        return String.valueOf(lat)+","+String.valueOf(lng);
    }
}
