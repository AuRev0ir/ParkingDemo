package com.spring.app.service;

import com.spring.app.dao.model.Address;

public interface AddressService {

    Address add (String cityName, String name, int houseNumber);
    Address getInfo (long parkingId);

}
