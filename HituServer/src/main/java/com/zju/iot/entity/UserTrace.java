package com.zju.iot.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by amei on 16-12-10.
 */
@Data
public class UserTrace implements Serializable{
    private static final long serialVersionUID = 4722071752242228908L;
    private String userID;
    private String traceID;
    private Double longitude;
    private Double latitude;
    private String province;
    private String city;
    private String district;
    private String street;
    // 描述性说明
    private String address;
    private Long date;
    private String strdate;
}
