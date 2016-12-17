package com.zju.iot.entity;

import java.util.Date;

/**
 * Created by amei on 16-12-15.
 */
public class HistoryPlan {
    String planID;
    private String province;
    private String city;
    //users will select any place as starting point.It is got from Baidu map
    private String startPlace;
    // the longitude and latitude of start place. It is got from Baidu map
    private double startlng;
    private double startlat;
    private Date commitTime;

}
