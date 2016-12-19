package com.zju.iot.entity;

import lombok.Data;

import java.util.ArrayList;

/**
 * Created by amei on 16-12-19.
 */
@Data
public class Direction {
    private Spot origin;
    private Spot destination;
    private Taxi taxi;
    private int total;
    private ArrayList<Route> routes;
}
