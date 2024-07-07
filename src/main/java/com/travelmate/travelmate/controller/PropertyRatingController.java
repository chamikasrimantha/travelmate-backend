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

import com.travelmate.travelmate.dto.PropertyRatingDto;
import com.travelmate.travelmate.entity.PropertyRatingEntity;
import com.travelmate.travelmate.service.PropertyRatingService;

@RestController
@CrossOrigin(origins = "*")
public class PropertyRatingController {

    @Autowired
    private PropertyRatingService propertyRatingService;

    @PostMapping("/property-ratings")
    public ResponseEntity<PropertyRatingEntity> addPropertyRate(@RequestBody PropertyRatingDto propertyRatingDto){
        try {
            return ResponseEntity.status(200).body(propertyRatingService.addPropertyRate(propertyRatingDto));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/property-ratings")
    public ResponseEntity<List<PropertyRatingEntity>> getAllPropertyRatings(){
        List<PropertyRatingEntity> propertyRatingEntities = propertyRatingService.getAllPropertyRatings();
        if (propertyRatingEntities!=null) {
            return ResponseEntity.status(200).body(propertyRatingEntities);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/property-ratings")
    public ResponseEntity<PropertyRatingEntity> getPropertyRatingsById(@PathVariable Long id){
        PropertyRatingEntity propertyRatingEntity = propertyRatingService.getPropertyRatingsById(id);
        if (propertyRatingEntity!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(propertyRatingEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/users/{id}/property-ratings")
    public ResponseEntity<List<PropertyRatingEntity>> getPropertyRatingsByUser(@PathVariable Long id){
        return ResponseEntity.ok().body(propertyRatingService.getPropertyRatingsByUser(id));
    }

    @GetMapping("/properties/{id}/property-ratings")
    public ResponseEntity<List<PropertyRatingEntity>> getPropertyRatingsByProperty(@PathVariable Long id){
        return ResponseEntity.ok().body(propertyRatingService.getPropertyRatingsByProperty(id));
    }

    @PutMapping("/property-ratings/{id}")
    public PropertyRatingEntity updatePropertyRate(@PathVariable Long id, @RequestBody PropertyRatingEntity propertyRatingEntity){
        return propertyRatingService.updatePropertyRate(id, propertyRatingEntity);
    }

    @DeleteMapping("/property-ratings/{id}")
    public PropertyRatingEntity deletePropertyRate(@PathVariable Long id){
        return propertyRatingService.deletePropertyRate(id);
    }
    
}
