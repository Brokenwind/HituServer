package com.zju.iot.map.baidu.entity;

import lombok.Data;

import java.util.ArrayList;

/**
 * Created by amei on 16-12-20.
 */
@Data
public class BaiduRouteMatrix {
    private int status;
    private String message;
    private ArrayList<BaiduRouteMatrixItem> result;
}
