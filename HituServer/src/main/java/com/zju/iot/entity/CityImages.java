package com.zju.iot.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by amei on 17-3-20.
 */
@Data
public class CityImages implements Serializable{
    private static final long serialVersionUID = 7274247830359191713L;
    private String cityID;
    private String imageID;
    private String imageUrl;
    private String imageName;
    private String imageDesc;
}
