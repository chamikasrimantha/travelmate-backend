package com.travelmate.travelmate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travelmate.travelmate.dto.CityDto;
import com.travelmate.travelmate.entity.CityEntity;
import com.travelmate.travelmate.service.CityService;

@RestController
@CrossOrigin(origins = "*")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/cities")
    public ResponseEntity<CityEntity> addCity(@RequestBody CityDto cityDto){
        try {
            return ResponseEntity.status(200).body(cityService.addCity(cityDto));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/cities")
    public ResponseEntity<List<CityEntity>> getAllCities(){
        List<CityEntity> cityEntities = cityService.getAllCities();
        if (cityEntities!=null) {
            return ResponseEntity.status(200).body(cityEntities);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<CityEntity> getCitiesById(@PathVariable Long id){
        CityEntity cityEntity = cityService.getCitiesById(id);
        if (cityEntity!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(cityEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/districts/{id}/cities")
    public ResponseEntity<List<CityEntity>> getCitiesByDistrict(@PathVariable Long id){
        return ResponseEntity.ok().body(cityService.getCitiesByDistrict(id));
    }
    
}
