package com.zju.iot.map.baidu.entity;

import com.zju.iot.entity.GeoMark;
import lombok.Data;

import java.util.ArrayList;

/**
 * Created by amei on 16-12-20.
 * 逆地理编码
 */
@Data
public class BaiduRevGeoCode {
    /**longitude and latitude**/
    private GeoMark location;
    /**结构化地址信息**/
    private String formatted_address;
    /**所在商圈信息，如 "人民大学,中关村,苏州街"**/
    private String business;
    private BaiduAddress addressComponent;
    /**周边poi数组**/
    private ArrayList<BaiduPoi> pois;
    /**当前位置结合POI的语义化结果描述**/
    private String sematic_description;
}
