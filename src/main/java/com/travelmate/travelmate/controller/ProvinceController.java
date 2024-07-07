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

import com.travelmate.travelmate.entity.ProvinceEntity;
import com.travelmate.travelmate.service.ProvinceService;

@RestController
@CrossOrigin(origins = "*")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @PostMapping("/provinces")
    public ResponseEntity<ProvinceEntity> addProvince(@RequestBody ProvinceEntity provinceEntity){
        try {
            return ResponseEntity.status(200).body(provinceService.addProvince(provinceEntity));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/provinces")
    public ResponseEntity<List<ProvinceEntity>> getAllProvinces(){
        List<ProvinceEntity> provinceEntities = provinceService.getAllProvinces();
        if (provinceEntities!=null) {
            return ResponseEntity.status(200).body(provinceEntities);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/provinces/{id}")
    public ResponseEntity<ProvinceEntity> getProvinceById(@PathVariable Long id){
        ProvinceEntity provinceEntity = provinceService.getProvinceById(id);
        if (provinceEntity!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(provinceEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
}
