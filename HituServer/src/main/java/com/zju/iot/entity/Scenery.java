package com.zju.iot.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by amei on 16-12-9.
 */

@Data
public class Scenery implements Serializable{
    private static final long serialVersionUID = -6096339472163774915L;
    private String sceneryID;
    private String name;
    private String province;
    private String city;
    private String area;
    private String level;
    private String quality;
    private String description;
    private String website;
    private String symbolImage;
    private String openTime;
    private String closeTime;
    private String price;
    private String suggest;
    private String season;
    private String type;
    private double longitude;
    private double latitude;
    private int precise;
    private int confidence;
}
