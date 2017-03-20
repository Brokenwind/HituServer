package com.zju.iot.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by amei on 16-12-19.
 */
@Data
public class Route implements Serializable{
    // generage routeID with searching start and end
    private String routeID;
    // it is real the route start and end. and it may not be simillar to searching start and end
    private String start;
    private double startLng;
    private double startLat;
    private String end;
    private double endLng;
    private double endLat;
    private int distance;
    private int duration;
    private String arriveTime;
    private double price;
    private int stepcount;
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

    @Override
    public String toString() {
        return "Route{" +
                "startLng=" + startLng +
                ", startLat=" + startLat +
                ", endLng=" + endLng +
                ", endLat=" + endLat +
                ", duration=" + duration +
                '}';
    }
}
