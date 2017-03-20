package com.zju.iot.dao;

import com.zju.iot.entity.City;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by amei on 16-12-10.
 */

@Component
public class CityDAO {
    @Inject
    private BaseDAO baseDAO;

    public City getCityByName(String name){
        String hsql="from City city where city.name like "+name+"%";
        return (City) baseDAO.uniqueResult(hsql);
    }

    public City getCityByID(String id){
        String hsql="from City city where city.cityID = ?";
        return (City) baseDAO.uniqueResult(hsql,id);
    }
}
