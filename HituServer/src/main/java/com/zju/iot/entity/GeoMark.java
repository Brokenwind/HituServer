package com.zju.iot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by amei on 16-12-19.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoMark {
    private String name;
    private double lng;
    private double lat;
    public GeoMark(double lng,double lat){
        this.lat = lat;
        this.lng = lng;
    }
    public String toString(){
        return String.valueOf(lat)+","+String.valueOf(lng);
    }

}
