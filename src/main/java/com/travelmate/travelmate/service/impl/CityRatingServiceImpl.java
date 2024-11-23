package com.travelmate.travelmate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.CityRatingDto;
import com.travelmate.travelmate.entity.CityEntity;
import com.travelmate.travelmate.entity.CityRatingEntity;
import com.travelmate.travelmate.entity.UserEntity;
import com.travelmate.travelmate.repository.CityRatingRepository;
import com.travelmate.travelmate.repository.CityRepository;
import com.travelmate.travelmate.repository.UserRepository;
import com.travelmate.travelmate.service.CityRatingService;

@Service
public class CityRatingServiceImpl implements CityRatingService {

    @Autowired
    private CityRatingRepository cityRatingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public CityRatingEntity addCityRate(CityRatingDto cityRatingDto) {
        UserEntity userEntity = userRepository.findById(cityRatingDto.getUserId()).orElse(null);
        CityEntity cityEntity = cityRepository.findById(cityRatingDto.getCityId()).orElse(null);
        if (userEntity != null && cityEntity != null) {
            CityRatingEntity cityRatingEntity = new CityRatingEntity();
            cityRatingEntity.setRate(cityRatingDto.getRate());
            cityRatingEntity.setComment(cityRatingDto.getComment());
            cityRatingEntity.setUserEntity(userEntity);
            cityRatingEntity.setCityEntity(cityEntity);
            return cityRatingRepository.save(cityRatingEntity);
        } else {
            return null;
        }
    }

    @Override
    public CityRatingEntity deleteCityRate(Long id) {
        CityRatingEntity existingCityRatings = cityRatingRepository.findById(id).orElse(null);
        if (existingCityRatings != null) {
            cityRatingRepository.delete(existingCityRatings);
            return existingCityRatings;
        } else {
            return null;
        }
    }

    @Override
    public List<CityRatingEntity> getAllCityRatings() {
        return cityRatingRepository.findAll();
    }

    @Override
    public List<CityRatingEntity> getCityRatingsByCity(Long id) {
        CityEntity cityEntity = cityRepository.findById(id).orElse(null);
        if (cityEntity != null) {
            return cityRatingRepository.findCityRatingsByCity(cityEntity);
        } else {
            return null;
        }
    }

    @Override
    public CityRatingEntity getCityRatingsById(Long id) {
        return cityRatingRepository.findById(id).orElse(null);
    }

    @Override
    public List<CityRatingEntity> getCityRatingsByUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity != null) {
            return cityRatingRepository.findCityRatingsByUser(userEntity);
        } else {
            return null;
        }
    }

    @Override
    public CityRatingEntity updateCityRate(Long id, CityRatingEntity cityRatingEntity) {
        CityRatingEntity existingCityRatings = cityRatingRepository.findById(id).orElse(null);
        if (existingCityRatings != null) {
            existingCityRatings.setRate(cityRatingEntity.getRate());
            existingCityRatings.setComment(cityRatingEntity.getComment());
            return cityRatingRepository.save(existingCityRatings);
        } else {
            return null;
        }
    }

}
