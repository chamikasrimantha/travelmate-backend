package com.travelmate.travelmate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.CityDto;
import com.travelmate.travelmate.entity.CityEntity;
import com.travelmate.travelmate.entity.DistrictEntity;
import com.travelmate.travelmate.repository.CityRepository;
import com.travelmate.travelmate.repository.DistrictRepository;
import com.travelmate.travelmate.service.CityService;

@Service
public class CityServiceImpl implements CityService{

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public CityEntity addCity(CityDto cityDto) {
        DistrictEntity districtEntity = districtRepository.findById(cityDto.getDistrictId()).orElse(null);
        if (districtEntity!=null) {
            CityEntity cityEntity = new CityEntity();
            cityEntity.setName(cityDto.getName());
            cityEntity.setPostCode(cityDto.getPostCode());
            cityEntity.setLatitude(cityDto.getLatitude());
            cityEntity.setLongitude(cityDto.getLongitude());
            cityEntity.setDistrictEntity(districtEntity);
            return cityRepository.save(cityEntity);
        } else {
            return null;
        }
    }

    @Override
    public List<CityEntity> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public List<CityEntity> getCitiesByDistrict(Long id) {
        DistrictEntity districtEntity = districtRepository.findById(id).orElse(null);
        if (districtEntity!=null) {
            return cityRepository.findCitiesByDistrict(districtEntity);
        } else {
            return null;
        }
    }

    @Override
    public CityEntity getCitiesById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }
    
}
