package com.zju.iot.dao;

import com.zju.iot.entity.CityImages;
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
public class CityImagesDAO {
    @Inject
    private SessionFactory sessionFactory;

    public ArrayList<CityImages> getImagesByCityID(String cityID){
        String hsql="from CityImages images where images.cityID = ?";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql);
        query.setString(0, cityID);
        return (ArrayList<CityImages>) query.list();
    }

    public int getImageCount(String cityID){
        String hsql="select count(*) from CityImages images where images.cityID = ?";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql);
        query.setString(0, cityID);
        return ((Long)query.uniqueResult()).intValue();
    }

}
