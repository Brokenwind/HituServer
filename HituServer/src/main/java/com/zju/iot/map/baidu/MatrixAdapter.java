package com.zju.iot.map.baidu;

import com.alibaba.fastjson.JSON;
import com.zju.iot.map.baidu.entity.BaiduRouteMatrix;

/**
 * Created by amei on 16-12-20.
 */
public class MatrixAdapter {
    public static BaiduRouteMatrix getRouteMatrix(String data){
        if (data == null || data.equals(""))
            return null;
        return JSON.parseObject(data,BaiduRouteMatrix.class);
    }
}
