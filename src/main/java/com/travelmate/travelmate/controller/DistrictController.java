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

import com.travelmate.travelmate.dto.DistrictDto;
import com.travelmate.travelmate.entity.DistrictEntity;
import com.travelmate.travelmate.service.DistrictService;

@RestController
@CrossOrigin(origins = "*")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @PostMapping("/districts")
    public ResponseEntity<DistrictEntity> addDistrict(@RequestBody DistrictDto districtDto){
        try {
            return ResponseEntity.status(200).body(districtService.addDistrict(districtDto));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/districts")
    public ResponseEntity<List<DistrictEntity>> getAllDistricts(){
        List<DistrictEntity> districtEntities = districtService.getAllDistricts();
        if (districtEntities!=null) {
            return ResponseEntity.status(200).body(districtEntities);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/districts/{id}")
    public ResponseEntity<DistrictEntity> getDistrictById(@PathVariable Long id){
        DistrictEntity districtEntity = districtService.getDistrictsById(id);
        if (districtEntity!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(districtEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/provinces/{id}/districts")
    public ResponseEntity<List<DistrictEntity>> getDistrictsByProvince(@PathVariable Long id){
        return ResponseEntity.ok().body(districtService.getDistrictsByProvince(id));
    }
    
}
