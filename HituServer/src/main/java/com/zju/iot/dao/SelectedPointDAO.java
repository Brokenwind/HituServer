package com.zju.iot.dao;

import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by amei on 16-12-26.
 */
@Component
public class SelectedPointDAO {
    @Inject
    private BaseDAO baseDAO;

    public boolean addSelectedPoint(Object object){
        return baseDAO.save(object);
    }
    public boolean batchSelectedPoint(List objects){
        return baseDAO.batchSave(objects);
    }

}
