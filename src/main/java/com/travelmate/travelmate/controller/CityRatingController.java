package com.travelmate.travelmate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travelmate.travelmate.dto.CityRatingDto;
import com.travelmate.travelmate.entity.CityRatingEntity;
import com.travelmate.travelmate.service.CityRatingService;

@RestController
@CrossOrigin(origins = "*")
public class CityRatingController {

    @Autowired
    private CityRatingService cityRatingService;

    @PostMapping("/city-ratings")
    public ResponseEntity<CityRatingEntity> addCityRate(@RequestBody CityRatingDto cityRatingDto){
        try {
            return ResponseEntity.status(200).body(cityRatingService.addCityRate(cityRatingDto));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/city-ratings")
    public ResponseEntity<List<CityRatingEntity>> getAllCityRatings(){
        List<CityRatingEntity> cityRatingEntities = cityRatingService.getAllCityRatings();
        if (cityRatingEntities!=null) {
            return ResponseEntity.status(200).body(cityRatingEntities);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/city-ratings/{id}")
    public ResponseEntity<CityRatingEntity> getCityRatingsById(@PathVariable Long id){
        CityRatingEntity cityRatingEntity = cityRatingService.getCityRatingsById(id);
        if (cityRatingEntity!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(cityRatingEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/users/{id}/city-ratings")
    public ResponseEntity<List<CityRatingEntity>> getCityRatingsByUser(@PathVariable Long id){
        return ResponseEntity.ok().body(cityRatingService.getCityRatingsByUser(id));
    }

    @GetMapping("/cities/{id}/city-ratings")
    public ResponseEntity<List<CityRatingEntity>> getCityRatingsByCity(@PathVariable Long id){
        return ResponseEntity.ok().body(cityRatingService.getCityRatingsByCity(id));
    }

    @PutMapping("city-ratings/{id}")
    public CityRatingEntity updateCityRate(@PathVariable Long id, @RequestBody CityRatingEntity cityRatingEntity){
        return cityRatingService.updateCityRate(id, cityRatingEntity);
    }

    @DeleteMapping("/city-ratings/{id}")
    public CityRatingEntity deleteCityRate(@PathVariable Long id){
        return cityRatingService.deleteCityRate(id);
    }
    
}
