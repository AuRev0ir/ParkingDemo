package com.spring.app.rest.controller;

import com.spring.app.rest.dto.ParkingDto;
import com.spring.app.service.ParkingService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/v1/maps")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ParkingController {
    ParkingService parkingService;

    @GetMapping("/")
    public List<ParkingDto> getAll() {
        return parkingService.getAll();
    }

    @GetMapping("/{parking_id}")
    public ParkingDto getInfo(@PathVariable("parking_id") UUID id) {
        return parkingService.getInfo(id);
    }

    @PostMapping("/")
    public UUID add(@RequestBody ParkingDto dto) {
        return parkingService.create(dto);
    }

    @PatchMapping("/")
    public ParkingDto update(@RequestBody ParkingDto dto) {
        return parkingService.update(dto);
    }

    @DeleteMapping("/{parking_id}")
    public boolean removeParking(@PathVariable("parking_id") UUID id) {
        return parkingService.delete(id);
    }
}



