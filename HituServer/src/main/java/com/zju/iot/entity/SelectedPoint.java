package com.zju.iot.entity;

import lombok.Data;

/**
 * Created by amei on 16-12-25.
 *
 * the place the user add to plan
 */
@Data
public class SelectedPoint {
    private String selectedID;
    private double lng;
    private double lat;
    private int openTime;
    private int closeTime;
    private int stayTime;
    private float price;
    private int level;

    public GeoMark getMark(){
        return new GeoMark(lng,lat);
    }

    public void setMark(GeoMark mark){
        if ( mark != null ){
            this.lng = mark.getLng();
            this.lat = mark.getLat();
        }
    }
}
