package com.zju.iot.map.baidu.entity;

import lombok.Data;

/**
 * Created by amei on 16-12-20.
 */
@Data
public class BaiduDistAndDura {
    // 线路距离的文本描述,or 路线耗时的文本描述
    private String text;
    // 线路距离的数值, or 路线耗时的数值
    private double value;
}
