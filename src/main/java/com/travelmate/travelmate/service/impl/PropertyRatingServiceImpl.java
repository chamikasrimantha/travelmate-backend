package com.travelmate.travelmate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.PropertyRatingDto;
import com.travelmate.travelmate.entity.PropertyEntity;
import com.travelmate.travelmate.entity.PropertyRatingEntity;
import com.travelmate.travelmate.entity.UserEntity;
import com.travelmate.travelmate.repository.PropertyRatingRepository;
import com.travelmate.travelmate.repository.PropertyRepository;
import com.travelmate.travelmate.repository.UserRepository;
import com.travelmate.travelmate.service.PropertyRatingService;

@Service
public class PropertyRatingServiceImpl implements PropertyRatingService {

    @Autowired
    private PropertyRatingRepository propertyRatingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public PropertyRatingEntity addPropertyRate(PropertyRatingDto propertyRatingDto) {
        UserEntity userEntity = userRepository.findById(propertyRatingDto.getUserId()).orElse(null);
        PropertyEntity propertyEntity = propertyRepository.findById(propertyRatingDto.getPropertyId()).orElse(null);
        if (userEntity!=null && propertyEntity!=null) {
            PropertyRatingEntity propertyRatingEntity = new PropertyRatingEntity();
            propertyRatingEntity.setRate(propertyRatingDto.getRate());
            propertyRatingEntity.setComment(propertyRatingDto.getComment());
            propertyRatingEntity.setUserEntity(userEntity);
            propertyRatingEntity.setPropertyEntity(propertyEntity);
            return propertyRatingRepository.save(propertyRatingEntity);
        } else {
            return null;
        }
    }

    @Override
    public PropertyRatingEntity deletePropertyRate(Long id) {
        PropertyRatingEntity existingPropertyRatings = propertyRatingRepository.findById(id).orElse(null);
        if (existingPropertyRatings!=null) {
            propertyRatingRepository.delete(existingPropertyRatings);
            return existingPropertyRatings;
        } else {
            return null;
        }
    }

    @Override
    public List<PropertyRatingEntity> getAllPropertyRatings() {
        return propertyRatingRepository.findAll();
    }

    @Override
    public PropertyRatingEntity getPropertyRatingsById(Long id) {
        return propertyRatingRepository.findById(id).orElse(null);
    }

    @Override
    public List<PropertyRatingEntity> getPropertyRatingsByProperty(Long id) {
        PropertyEntity propertyEntity = propertyRepository.findById(id).orElse(null);
        if (propertyEntity!=null) {
            return propertyRatingRepository.findPropertyRatingsByProperty(propertyEntity);
        } else {
            return null;
        }
    }

    @Override
    public List<PropertyRatingEntity> getPropertyRatingsByUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity!=null) {
            return propertyRatingRepository.findPropertyRatingsByUser(userEntity);
        } else {
            return null;
        }
    }

    @Override
    public PropertyRatingEntity updatePropertyRate(Long id, PropertyRatingEntity propertyRatingEntity) {
        PropertyRatingEntity existingPropertyRatings = propertyRatingRepository.findById(id).orElse(null);
        if (existingPropertyRatings!=null) {
            existingPropertyRatings.setRate(propertyRatingEntity.getRate());
            existingPropertyRatings.setComment(propertyRatingEntity.getComment());
            return propertyRatingRepository.save(existingPropertyRatings);
        } else {
            return null;
        }
    }

}
 