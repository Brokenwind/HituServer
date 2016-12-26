package com.zju.iot.map.baidu.entity;

import lombok.Data;

/**
 * Created by amei on 16-12-20.
 */
@Data
public class BaiduPoi {
    //地址信息
    private String addr;
    //数据来源
    private String cp;
    //和当前坐标点的方向
    private String direction;
    //离坐标点距离
    private int distance;
    //poi名称
    private String name;
    //poi类型，如’ 办公大厦,商务大厦’
    private String poiType;
    // poi坐标{x,y}
    private BaiduPoint point;
    //电话
    private String tel;
    //poi唯一标识
    private String uid;
    // 邮编
    private String zip;
}
