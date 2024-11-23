package com.travelmate.travelmate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelmate.travelmate.entity.ProvinceEntity;
import com.travelmate.travelmate.repository.ProvinceRepository;
import com.travelmate.travelmate.service.ProvinceService;

@Service
public class ProvinceServiceImpl implements ProvinceService{

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public ProvinceEntity addProvince(ProvinceEntity provinceEntity) {
        return provinceRepository.save(provinceEntity);
    }

    @Override
    public List<ProvinceEntity> getAllProvinces() {
        return provinceRepository.findAll();
    }

    @Override
    public ProvinceEntity getProvinceById(Long id) {
        return provinceRepository.findById(id).orElse(null);
    }
    
}
