package com.zju.iot.entity;

import lombok.Data;

/**
 * Created by amei on 16-12-25.
 */
@Data
public class CalculateRoute {
    private GeoMark original;
    private GeoMark destination;
    private Route route;
    // when the CalculateRoute object stores in HashMap,it is used to be the key
    public String getKey(){
        return original.toString()+destination.toString();
    }
}
