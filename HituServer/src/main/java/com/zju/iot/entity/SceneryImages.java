package com.zju.iot.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by amei on 16-12-9.
 */

@Data
public class SceneryImages implements Serializable{
    private static final long serialVersionUID = 2978823251444906183L;
    private String sceneryID;
    private String imageID;
    private String imageUrl;
    private String imageName;
    private String imageDesc;
}
