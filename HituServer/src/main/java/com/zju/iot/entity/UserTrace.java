package com.zju.iot.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by amei on 16-12-10.
 */
@Data
public class UserTrace implements Serializable{
    private String userID;
    private String traceID;
    private double longtude;
    private double latitude;
    private String position;
}
