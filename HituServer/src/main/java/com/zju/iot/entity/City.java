package com.zju.iot.entity;

import lombok.Data;

/**
 * Created by amei on 17-3-20.
 */
@Data
public class City {
    String cityID;
    String name;
    String province;
    // 地级市
    String type;
    // 所属地区
    String area;
    // 电话区号
    String zoneNum;
    // 面积
    String acreage;
    // 气候
    String climate;
    // 邮政编码
    String zipcode;
    Double longitude;
    Double latitude;
    // 简单描述
    String description;
}
