package com.zju.iot.dao;

import com.zju.iot.entity.SceneryImages;
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
public class SceneryImagesDAO {
    @Inject
    private SessionFactory sessionFactory;

    public ArrayList<SceneryImages> getImagesBySceneryID(String sceneryID){
        String hsql="from SceneryImages images where images.sceneryID = ?";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql);
        query.setString(0, sceneryID);
        return (ArrayList<SceneryImages>) query.list();
    }

    public int getImageCount(String sceneryID){
        String hsql="select count(*) from SceneryImages images where images.sceneryID = ?";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql);
        query.setString(0, sceneryID);
        return ((Long)query.uniqueResult()).intValue();
    }

}
