package com.travelmate.travelmate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.PropertyRatingDto;
import com.travelmate.travelmate.entity.PropertyRatingEntity;

@Service
public interface PropertyRatingService {
    PropertyRatingEntity addPropertyRate(PropertyRatingDto propertyRatingDto);
    List<PropertyRatingEntity> getAllPropertyRatings();
    PropertyRatingEntity getPropertyRatingsById(Long id);
    List<PropertyRatingEntity> getPropertyRatingsByUser(Long id);
    List<PropertyRatingEntity> getPropertyRatingsByProperty(Long id);
    PropertyRatingEntity updatePropertyRate(Long id, PropertyRatingEntity propertyRatingEntity);
    PropertyRatingEntity deletePropertyRate(Long id);
}
