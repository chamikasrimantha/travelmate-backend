package com.travelmate.travelmate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelmate.travelmate.entity.ProvinceEntity;

@Service
public interface ProvinceService {
    ProvinceEntity addProvince(ProvinceEntity provinceEntity);
    List<ProvinceEntity> getAllProvinces();
    ProvinceEntity getProvinceById(Long id);
}
