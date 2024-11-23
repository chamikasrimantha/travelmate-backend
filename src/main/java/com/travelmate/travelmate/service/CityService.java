package com.travelmate.travelmate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.CityDto;
import com.travelmate.travelmate.entity.CityEntity;

@Service
public interface CityService {
    CityEntity addCity(CityDto cityDto);
    List<CityEntity> getAllCities();
    CityEntity getCitiesById(Long id);
    List<CityEntity> getCitiesByDistrict(Long id);
}
