package com.spring.app.service;

import com.spring.app.dao.model.Parking;

import java.util.List;

public interface ParkingService {

    List<Parking> getAll();

    Parking getInfo(long id);

    //create

    Long add();
    Long update();

    //delite
    void remove(long id);

}
