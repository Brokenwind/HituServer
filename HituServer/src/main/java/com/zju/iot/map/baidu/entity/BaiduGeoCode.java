package com.zju.iot.map.baidu.entity;

import com.zju.iot.entity.GeoMark;
import lombok.Data;

/**
 * Created by amei on 16-12-20.
 */
@Data
public class BaiduGeoCode {
    private GeoMark location;
    private int precise;
    private int confidence;
    private String level;
}
