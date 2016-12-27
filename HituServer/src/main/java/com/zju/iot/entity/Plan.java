package com.zju.iot.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by amei on 16-12-15.
 * It stores the information of sceneries of current plan
 */

@Data
public class Plan implements Serializable{
    private String userID;
    private String planID;
    private String province;
    private String city;
    // where you made you plan
    private Double planlng;
    private Double planlat;
    private Long createTime;
    //0: not, 1: yes
    private Integer isCommit;
    private Long commitTime;

    public GeoMark getPlanGeoMark(){
        return new GeoMark(planlng,planlat);
    }

    public void setPlanGeoMark(GeoMark mark){
        if (mark != null){
            this.planlng = mark.getLng();
            this.planlat = mark.getLat();
        }
    }

}
