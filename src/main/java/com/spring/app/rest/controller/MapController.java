package com.spring.app.rest.controller;

import com.spring.app.dao.model.Address;
import com.spring.app.dao.model.City;
import com.spring.app.dao.model.Parking;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;



// не реализованно 3 метода : addAddress, addParking
// и метод "Запрос всех событий парковочного пространства"

// Неуверене в подходящем названии
//
//@RestController
//@RequestMapping("/v1/maps")
//@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//public class MapController {
//
//
//
//    @GetMapping("/")
//    public List<Parking> getAll (){
//        return mapService.getAll();
//    }
//
//    @GetMapping("/{parking_id}")
//    public Parking getInfoParking (@PathVariable("parking_id") long id){
//        return mapService.getInfoParking(id);
//    }
//
//    @GetMapping("/address/{parking_id}")
//    public Address getInfoAddress (@PathVariable("parking_id") long id){
//        return mapService.getInfoAddress(id);
//    }
//
//    @GetMapping("city/{parking_id}")
//    public City getInfoCity (@PathVariable("parking_id") long id){
//        return mapService.getInfoCity(id);
//    }
//
//
//
//    @PostMapping("/сity")
//    public long addCity(@RequestBody City city){
//        return mapService.addCity(city);
//    }
//
//
//    @DeleteMapping("/{parking_id}")
//    public void removeParking(@PathVariable("parking_id") long id){
//        mapService.removeParking(id);
//    }












//}
