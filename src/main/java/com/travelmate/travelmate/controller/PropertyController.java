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

import com.travelmate.travelmate.dto.PropertyDto;
import com.travelmate.travelmate.entity.PropertyEntity;
import com.travelmate.travelmate.service.PropertyService;

@RestController
@CrossOrigin(origins = "*")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/properties")
    public ResponseEntity<PropertyEntity> createProperty(@RequestBody PropertyDto propertyDto){
        try {
            return ResponseEntity.status(200).body(propertyService.createProperty(propertyDto));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyEntity>> getAllProperties(){
        List<PropertyEntity> propertyEntities = propertyService.getAllProperties();
        if (propertyEntities!=null) {
            return ResponseEntity.status(200).body(propertyEntities);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/properties/{id}")
    public ResponseEntity<PropertyEntity> getPropertiesById(@PathVariable Long id){
        PropertyEntity propertyEntity = propertyService.getPropertiesById(id);
        if (propertyEntity!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(propertyEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/users/{id}/properties")
    public ResponseEntity<List<PropertyEntity>> getPropertiesByUser(@PathVariable Long id){
        return ResponseEntity.ok().body(propertyService.getPropertiesByUser(id));
    }

    @GetMapping("/categories/{id}/properties")
    public ResponseEntity<List<PropertyEntity>> getPropertiesByCategory(@PathVariable Long id){
        return ResponseEntity.ok().body(propertyService.getPropertiesByCategory(id));
    }

    @GetMapping("/districts/{id}/properties")
    public ResponseEntity<List<PropertyEntity>> getPropertiesByDistrict(@PathVariable Long id){
        return ResponseEntity.ok().body(propertyService.getPropertiesByDistrict(id));
    }

    @GetMapping("/cities/{id}/properties")
    public ResponseEntity<List<PropertyEntity>> getPropertiesByCity(@PathVariable Long id){
        return ResponseEntity.ok().body(propertyService.getPropertiesByCity(id));
    }

    @PutMapping("/properties/{id}")
    public PropertyEntity updateProperty(@PathVariable Long id, @RequestBody PropertyEntity propertyEntity){
        return propertyService.updateProperty(id, propertyEntity);
    }

    @DeleteMapping("/properties/{id}")
    public PropertyEntity deleteProperty(@PathVariable Long id){
        return propertyService.deleteProperty(id);
    }
    
}
