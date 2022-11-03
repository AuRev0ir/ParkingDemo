package com.spring.app.rest.controller;

import com.spring.app.rest.dto.CityDto;
import com.spring.app.service.CityService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/maps")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CityController {

    CityService cityService;


    @GetMapping("city/{parking_id}")
    public CityDto getInfo(@PathVariable("parking_id") UUID id){
        return cityService.getInfo(id);
    }

    @PostMapping("/сity")
    public boolean add (CityDto dto){
        return cityService.addCity(dto);
    }

}
