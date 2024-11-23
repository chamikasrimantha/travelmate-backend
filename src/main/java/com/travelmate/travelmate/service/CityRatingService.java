package com.travelmate.travelmate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.CityRatingDto;
import com.travelmate.travelmate.entity.CityRatingEntity;

@Service
public interface CityRatingService {
    CityRatingEntity addCityRate(CityRatingDto cityRatingDto);
    List<CityRatingEntity> getAllCityRatings();
    CityRatingEntity getCityRatingsById(Long id);
    List<CityRatingEntity> getCityRatingsByUser(Long id);
    List<CityRatingEntity> getCityRatingsByCity(Long id);
    CityRatingEntity updateCityRate(Long id, CityRatingEntity cityRatingEntity);
    CityRatingEntity deleteCityRate(Long id);
}
