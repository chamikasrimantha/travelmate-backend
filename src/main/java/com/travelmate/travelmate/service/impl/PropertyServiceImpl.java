package com.travelmate.travelmate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.PropertyDto;
import com.travelmate.travelmate.entity.CategoryEntity;
import com.travelmate.travelmate.entity.CityEntity;
import com.travelmate.travelmate.entity.DistrictEntity;
import com.travelmate.travelmate.entity.PropertyEntity;
import com.travelmate.travelmate.entity.UserEntity;
import com.travelmate.travelmate.repository.CategoryRepository;
import com.travelmate.travelmate.repository.CityRepository;
import com.travelmate.travelmate.repository.DistrictRepository;
import com.travelmate.travelmate.repository.PropertyRepository;
import com.travelmate.travelmate.repository.UserRepository;
import com.travelmate.travelmate.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public PropertyEntity createProperty(PropertyDto propertyDto) {
        UserEntity userEntity = userRepository.findById(propertyDto.getUserId()).orElse(null);
        CategoryEntity categoryEntity = categoryRepository.findById(propertyDto.getCategoryId()).orElse(null);
        DistrictEntity districtEntity = districtRepository.findById(propertyDto.getDistrictId()).orElse(null);
        CityEntity cityEntity = cityRepository.findById(propertyDto.getCityId()).orElse(null);
        if (userEntity != null && categoryEntity != null && districtEntity != null && cityEntity != null) {
            PropertyEntity propertyEntity = new PropertyEntity();
            propertyEntity.setName(propertyDto.getName());
            propertyEntity.setEmail(propertyDto.getEmail());
            propertyEntity.setHotline(propertyDto.getHotline());
            propertyEntity.setLocation(propertyDto.getLocation());
            propertyEntity.setSentence(propertyDto.getSentence());
            propertyEntity.setDescription(propertyDto.getDescription());
            propertyEntity.setImg(propertyDto.getImg());
            propertyEntity.setPrice(propertyDto.getPrice());
            // bedrooms
            propertyEntity.setBedrooms(propertyDto.getBedrooms());
            propertyEntity.setGuests(propertyDto.getGuests());
            // services
            propertyEntity.setAirconditioning(propertyDto.getAirconditioning());
            propertyEntity.setHeating(propertyDto.getHeating());
            propertyEntity.setWifi(propertyDto.getWifi());
            propertyEntity.setKitchen(propertyDto.getKitchen());
            propertyEntity.setBreakfast(propertyDto.getBreakfast());
            propertyEntity.setWashingmachine(propertyDto.getWashingmachine());
            propertyEntity.setTv(propertyDto.getTv());
            propertyEntity.setSwimmingpool(propertyDto.getSwimmingpool());
            propertyEntity.setHottub(propertyDto.getHottub());
            propertyEntity.setBalcony(propertyDto.getBalcony());
            propertyEntity.setParking(propertyDto.getParking());
            propertyEntity.setTerrace(propertyDto.getTerrace());
            // rules
            propertyEntity.setCheckin(propertyDto.getCheckin());
            propertyEntity.setCheckout(propertyDto.getCheckout());
            propertyEntity.setAgerestriction(propertyDto.getAgerestriction());
            propertyEntity.setSmoking(propertyDto.getSmoking());
            propertyEntity.setParties(propertyDto.getParties());
            propertyEntity.setPets(propertyDto.getPets());
            propertyEntity.setPaymentMethods(propertyDto.getPaymentMethods());
            // host profile - owner
            propertyEntity.setFirstName(propertyDto.getFirstName());
            propertyEntity.setLastName(propertyDto.getLastName());
            propertyEntity.setBusinessName(propertyDto.getBusinessName());
            propertyEntity.setLivingAddress(propertyDto.getLivingAddress());
            propertyEntity.setPhoneNo(propertyDto.getPhoneNo());
            propertyEntity.setEmailAddress(propertyDto.getEmailAddress());
            // status - VERIFIED - NOT VERIFIED
            propertyEntity.setStatus(propertyDto.getStatus());
            // relationships
            propertyEntity.setUserEntity(userEntity);
            propertyEntity.setCategoryEntity(categoryEntity);
            propertyEntity.setDistrictEntity(districtEntity);
            propertyEntity.setCityEntity(cityEntity);
            // send email
            return propertyRepository.save(propertyEntity);
        } else {
            return null;
        }
    }

    @Override
    public PropertyEntity deleteProperty(Long id) {
        PropertyEntity existingProperty = propertyRepository.findById(id).orElse(null);
        if (existingProperty != null) {
            propertyRepository.delete(existingProperty);
            return existingProperty;
        } else {
            return null;
        }
    }

    @Override
    public List<PropertyEntity> getAllProperties() {
        return propertyRepository.findAll();
    }

    @Override
    public List<PropertyEntity> getPropertiesByCategory(Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElse(null);
        if (categoryEntity != null) {
            return propertyRepository.findPropertiesByCategory(categoryEntity);
        } else {
            return null;
        }
    }

    @Override
    public List<PropertyEntity> getPropertiesByCity(Long id) {
        CityEntity cityEntity = cityRepository.findById(id).orElse(null);
        if (cityEntity != null) {
            return propertyRepository.findPropertiesByCity(cityEntity);
        } else {
            return null;
        }
    }

    @Override
    public List<PropertyEntity> getPropertiesByDistrict(Long id) {
        DistrictEntity districtEntity = districtRepository.findById(id).orElse(null);
        if (districtEntity != null) {
            return propertyRepository.findPropertiesByDistrict(districtEntity);
        } else {
            return null;
        }
    }

    @Override
    public PropertyEntity getPropertiesById(Long id) {
        return propertyRepository.findById(id).orElse(null);
    }

    @Override
    public List<PropertyEntity> getPropertiesByUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity != null) {
            return propertyRepository.findPropertiesByPartner(userEntity);
        } else {
            return null;
        }
    }

    @Override
    public PropertyEntity updateProperty(Long id, PropertyEntity propertyEntity) {
        PropertyEntity existingProperty = propertyRepository.findById(id).orElse(null);
        if (existingProperty != null) {
            existingProperty.setName(propertyEntity.getName());
            existingProperty.setEmail(propertyEntity.getEmail());
            existingProperty.setHotline(propertyEntity.getHotline());
            existingProperty.setLocation(propertyEntity.getLocation());
            existingProperty.setSentence(propertyEntity.getSentence());
            existingProperty.setDescription(propertyEntity.getDescription());
            existingProperty.setImg(propertyEntity.getImg());
            existingProperty.setPrice(propertyEntity.getPrice());
            // bedrooms
            existingProperty.setBedrooms(propertyEntity.getBedrooms());
            existingProperty.setGuests(propertyEntity.getGuests());
            // services
            existingProperty.setAirconditioning(propertyEntity.getAirconditioning());
            existingProperty.setHeating(propertyEntity.getHeating());
            existingProperty.setWifi(propertyEntity.getWifi());
            existingProperty.setKitchen(propertyEntity.getKitchen());
            existingProperty.setBreakfast(propertyEntity.getBreakfast());
            existingProperty.setWashingmachine(propertyEntity.getWashingmachine());
            existingProperty.setTv(propertyEntity.getTv());
            existingProperty.setSwimmingpool(propertyEntity.getSwimmingpool());
            existingProperty.setHottub(propertyEntity.getHottub());
            existingProperty.setBalcony(propertyEntity.getBalcony());
            existingProperty.setParking(propertyEntity.getParking());
            existingProperty.setTerrace(propertyEntity.getTerrace());
            // rules
            existingProperty.setCheckin(propertyEntity.getCheckin());
            existingProperty.setCheckout(propertyEntity.getCheckout());
            existingProperty.setAgerestriction(propertyEntity.getAgerestriction());
            existingProperty.setSmoking(propertyEntity.getSmoking());
            existingProperty.setParties(propertyEntity.getParties());
            existingProperty.setPets(propertyEntity.getPets());
            existingProperty.setPaymentMethods(propertyEntity.getPaymentMethods());
            // host profile - owner
            existingProperty.setFirstName(propertyEntity.getFirstName());
            existingProperty.setLastName(propertyEntity.getLastName());
            existingProperty.setBusinessName(propertyEntity.getBusinessName());
            existingProperty.setLivingAddress(propertyEntity.getLivingAddress());
            existingProperty.setPhoneNo(propertyEntity.getPhoneNo());
            existingProperty.setEmailAddress(propertyEntity.getEmailAddress());
            // status - VERIFIED - NOT VERIFIED
            existingProperty.setStatus(propertyEntity.getStatus());

            return propertyRepository.save(existingProperty);
        } else {
            return null;
        }
    }

}
