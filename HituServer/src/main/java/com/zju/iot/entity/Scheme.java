package com.zju.iot.entity;

import com.zju.iot.common.utils.ParseUtil;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by amei on 16-12-19.
 */
@Data
public class Scheme implements Serializable{
    private String routeID;
    private String schemeID;
    private int stepnum;
    private int schemenum;
    private int distance;
    private int duration;
    private String instructions;
    private String path;
    private double startLng;
    private double startLat;
    private double endLng;
    private double endLat;
    private int vehicleType;
    /**Vehicle common**/
    private String vehicleName;
    private double price;
    private String booking;
    private String departureStation;
    private String arriveStation;
    private String departureTime;
    private String arriveTime;
    /**公交相关**/
    private int publicType; //市内公交的具体类型
    private int stopNum;
    private String onStation;
    private String offStation;
    private String lastTime;
    /**大巴相关**/
    private String providerName;
    private String providerUrl;
    /**飞机相关**/
    private String airlines;
    private double discount;

    public GeoMark getStart(){
        return new GeoMark(startLng,startLat);
    }

    public GeoMark getEnd(){
        return new GeoMark(endLng,endLat);
    }
    public void setStart(GeoMark start){
        if (start != null){
            this.startLng = start.getLng();
            this.startLat = start.getLat();
        }
    }

    public void setEnd(GeoMark end){
        if (end != null){
            this.endLng = end.getLng();
            this.endLat = end.getLat();
        }
    }

    // hash map key, and it will be the primary key of the relative table
    public String getKey(){
        return ParseUtil.getRouteKey(this.getStart(),this.getEnd());
    }

}
