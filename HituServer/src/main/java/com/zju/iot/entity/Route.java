package com.zju.iot.entity;

import com.zju.iot.common.utils.ParseUtil;
import lombok.Data;

import java.util.ArrayList;

/**
 * Created by amei on 16-12-19.
 */
@Data
public class Route {
    private String routeID;
    private double startLng;
    private double startLat;
    private double endLng;
    private double endLat;
    private int distance;
    private int duration;
    private String arriveTime;
    private double price;
    private ArrayList<Scheme> steps;

    public void setStartEnd(GeoMark start,GeoMark end){
        if (start != null && end != null) {
            this.startLng = start.getLng();
            this.startLat = start.getLat();
            this.endLng = end.getLng();
            this.endLat = end.getLat();
        }
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

    public GeoMark getStart(){
        return new GeoMark(startLng,startLat);
    }

    public GeoMark getEnd(){
        return new GeoMark(endLng,endLat);
    }

    // hash map key, and it will be the primary key of the relative table
    public String getKey(){
        return ParseUtil.getRouteKey(this.getStart(),this.getEnd());
    }
}
