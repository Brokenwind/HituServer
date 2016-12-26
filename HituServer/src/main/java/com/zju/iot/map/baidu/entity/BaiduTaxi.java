package com.zju.iot.map.baidu.entity;

import lombok.Data;

import java.util.ArrayList;

/**
 * Created by amei on 16-12-19.
 */
@Data
public class BaiduTaxi {
    private ArrayList<BaiduTaxiDetail> detail;
    /**出租车预计里程数 **/
    private int  distance;
    /**出租车预计耗时**/
    private int duration;
    /**出租车备注信息**/
    private String remark;
}
