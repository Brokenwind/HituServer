package com.zju.iot.entity;

import lombok.Data;

import java.util.ArrayList;

/**
 * Created by amei on 16-12-20.
 */
@Data
public class RouteMatrix {
    private int status;
    private String message;
    private ArrayList<RouteMatrixItem> result;
}
