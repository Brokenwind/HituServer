package com.zju.iot.dao;

import com.zju.iot.entity.Scenery;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by amei on 16-12-10.
 */

@Component
public class SceneryDAO {
    @Inject
    private SessionFactory sessionFactory;

    public Scenery getSceneryByName(String name){
        String hsql="from Scenery scenery where scenery.name = ?";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql);
        query.setString(0, name);
        return (Scenery) query.uniqueResult();
    }

    public Scenery getSceneryByID(String id){
        String hsql="from Scenery scenery where scenery.sceneryID = ?";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql);
        query.setString(0, id);
        return (Scenery) query.uniqueResult();
    }

    public ArrayList<Scenery> getSceneryByPos(String province, String city){
        String hsql="from Scenery scenery where scenery.province = ? and scenery.city = ?";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql);
        query.setString(0, province);
        query.setString(1, city);
        return (ArrayList<Scenery>) query.list();
    }

    public ArrayList<Scenery> getPagedSceneryByPos(String province, String city,int start,int num){
        String hsql="from Scenery scenery where scenery.province = ? and scenery.city = ?";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql);
        query.setString(0, province);
        query.setString(1, city);
        query.setFirstResult(start);
        query.setMaxResults(num);
        return (ArrayList<Scenery>) query.list();
    }

    public int getSceneryCount(){
        String hsql="select count(*) from Scenery scenery";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql);
        return ((Long)query.uniqueResult()).intValue();
    }
    public int getSceneryCount(String province){
        String hsql="select count(*) from Scenery scenery where scenery.province = ?";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql);
        query.setString(0, province);
        return ((Long)query.uniqueResult()).intValue();
    }
    public int getSceneryCount(String province,String city){
        String hsql="select count(*) from Scenery scenery where scenery.province = ? and scenery.city = ?";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql);
        query.setString(0, province);
        query.setString(1, city);
        return ((Long)query.uniqueResult()).intValue();
    }

}
