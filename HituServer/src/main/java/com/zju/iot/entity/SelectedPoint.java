package com.zju.iot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by amei on 16-12-25.
 *
 * the place the user add to plan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectedPoint implements Serializable{
    private String planID;
    private Integer type;
    private Double lng;
    private Double lat;
    private Integer openTime;
    private Integer closeTime;
    private Integer stayTime;
    private Integer level;
    private Double price;


    public GeoMark getMark(){
        return new GeoMark(lng,lat);
    }

    public void setMark(GeoMark mark){
        if ( mark != null ){
            this.lng = mark.getLng();
            this.lat = mark.getLat();
        }
    }

    @Override
    public String toString() {
        return "SelectedPoint{" +
                "planID='" + planID + '\'' +
                ", type=" + type +
                ", lng=" + lng +
                ", lat=" + lat +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", stayTime=" + stayTime +
                '}';
    }
}
