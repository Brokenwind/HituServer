package com.zju.iot.map;

/**
 * Created by amei on 16-12-17.
 * it is used to create ApiConfig object in ApiFactory,you must keep in mind
 */
public enum  ApiTypes {
    BAIDU_API(0,"Baidu"),
    GOOGLE_API(1,"Google"),
    AMAP(2,"Amap");
    private final String name;
    private final int id;
    private ApiTypes(int id,String name){
        this.id = id;
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
