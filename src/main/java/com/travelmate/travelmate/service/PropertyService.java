package com.travelmate.travelmate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.PropertyDto;
import com.travelmate.travelmate.entity.PropertyEntity;

@Service
public interface PropertyService {
    PropertyEntity createProperty(PropertyDto propertyDto);
    List<PropertyEntity> getAllProperties();
    PropertyEntity getPropertiesById(Long id);
    List<PropertyEntity> getPropertiesByUser(Long id);
    List<PropertyEntity> getPropertiesByCategory(Long id);
    List<PropertyEntity> getPropertiesByDistrict(Long id);
    List<PropertyEntity> getPropertiesByCity(Long id);
    PropertyEntity updateProperty(Long id, PropertyEntity propertyEntity);
    PropertyEntity deleteProperty(Long id);
}
