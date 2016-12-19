package com.zju.iot.entity;

import lombok.Data;

import java.util.ArrayList;

/**
 * Created by amei on 16-12-19.
 */
@Data
public class Route {
    private int distance;
    private int duration;
    private String arrive_time;
    private double price;
    private PriceDetail price_detail;
    private ArrayList<ArrayList<Scheme>> steps;
}
