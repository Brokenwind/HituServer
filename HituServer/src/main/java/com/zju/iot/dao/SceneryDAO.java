package com.zju.iot.dao;

import com.zju.iot.entity.Scenery;
import com.zju.iot.entity.SelectedPoint;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amei on 16-12-10.
 */

@Component
public class SceneryDAO {
    @Inject
    private BaseDAO baseDAO;

    public Scenery getSceneryByName(String name){
        String hsql="from Scenery scenery where scenery.name = ?";
        return (Scenery) baseDAO.uniqueResult(hsql,name);
    }

    public Scenery getSceneryByID(String id){
        String hsql="from Scenery scenery where scenery.sceneryID = ?";
        return (Scenery) baseDAO.uniqueResult(hsql,id);
    }

    public List<Scenery> getSceneryByPos(String province, String city){
        String hsql="from Scenery scenery where scenery.province = ? and scenery.city = ? order by scenery.level desc";
        ArrayList<String> params = new ArrayList<String>();
        params.add(province);
        params.add(city);
        return (ArrayList<Scenery>) baseDAO.getList(hsql,params);
    }

    public List<Scenery> getPagedSceneryByPos(String province, String city, int start, int num){
        String hsql="from Scenery scenery where scenery.province = ? and scenery.city = ?";
        ArrayList<String> params = new ArrayList<String>();
        params.add(province);
        params.add(city);
        return (ArrayList<Scenery>) baseDAO.getPagedList(hsql,params,start,num);
    }

    public long getSceneryCount(){
        String hsql="select count(*) from Scenery scenery";
        return baseDAO.getCount(hsql);
    }
    public long getSceneryCount(String province){
        String hsql="select count(*) from Scenery scenery where scenery.province = ?";
        return  baseDAO.getCount(hsql,province);
    }
    public long getSceneryCount(String province,String city){
        String hsql="select count(*) from Scenery scenery where scenery.province = ? and scenery.city = ?";
        ArrayList<String> params = new ArrayList<String>();
        params.add(province);
        params.add(city);
        return baseDAO.getCount(hsql,params);
    }

    public List<Scenery> getSceneryByCity(String city){
        String hsql="from Scenery scenery where scenery.city = ?";
        ArrayList<String> params = new ArrayList<String>();
        params.add(city);
        return (ArrayList<Scenery>) baseDAO.getList(hsql,params);
    }

    public List<Scenery> getPagedSceneryByCity(String city, int start, int num){
        String hsql="from Scenery scenery where scenery.city = ?";
        ArrayList<String> params = new ArrayList<String>();
        params.add(city);
        return (ArrayList<Scenery>) baseDAO.getPagedList(hsql,params,start,num);
    }

    public Scenery getSceneryByPoint(SelectedPoint point){
        String hsql="from Scenery scenery where scenery.longitude = ? and scenery.latitude = ?";
        ArrayList<String> params = new ArrayList<String>();
        params.add(String.valueOf(point.getLng()));
        params.add(String.valueOf(point.getLat()));
        return (Scenery) baseDAO.uniqueResult(hsql,params);
    }



}
