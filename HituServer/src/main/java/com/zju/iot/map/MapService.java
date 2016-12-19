package com.zju.iot.map;

import com.zju.iot.entity.Direction;
import com.zju.iot.entity.GeoMark;

/**
 * Created by amei on 16-12-19.
 */
public interface MapService {
    public Direction getDirection(GeoMark origin, GeoMark destination);
}
