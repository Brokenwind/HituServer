package com.zju.iot.map.baidu.entity;

import com.zju.iot.entity.GeoMark;
import lombok.Data;

/**
 * Created by amei on 16-12-19.
 */
@Data
public class BaiduSpot {
    private String city_id;
    private String city_name;
    private GeoMark location;
}
