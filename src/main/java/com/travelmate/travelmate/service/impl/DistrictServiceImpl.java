package com.travelmate.travelmate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.DistrictDto;
import com.travelmate.travelmate.entity.DistrictEntity;
import com.travelmate.travelmate.entity.ProvinceEntity;
import com.travelmate.travelmate.repository.DistrictRepository;
import com.travelmate.travelmate.repository.ProvinceRepository;
import com.travelmate.travelmate.service.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService{

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public DistrictEntity addDistrict(DistrictDto districtDto) {
        ProvinceEntity provinceEntity = provinceRepository.findById(districtDto.getProvinceId()).orElse(null);
        if (provinceEntity!=null) {
            DistrictEntity districtEntity = new DistrictEntity();
            districtEntity.setName(districtDto.getName());
            districtEntity.setProvinceEntity(provinceEntity);
            return districtRepository.save(districtEntity);
        } else {
            return null;
        }
    }

    @Override
    public List<DistrictEntity> getAllDistricts() {
        return districtRepository.findAll();
    }

    @Override
    public DistrictEntity getDistrictsById(Long id) {
        return districtRepository.findById(id).orElse(null);
    }

    @Override
    public List<DistrictEntity> getDistrictsByProvince(Long id) {
        ProvinceEntity provinceEntity = provinceRepository.findById(id).orElse(null);
        if (provinceEntity!=null) {
            return districtRepository.findDistrictsByProvince(provinceEntity);
        } else {
            return null;
        }
    }
    
}
