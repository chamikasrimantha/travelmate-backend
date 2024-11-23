package com.travelmate.travelmate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.DistrictDto;
import com.travelmate.travelmate.entity.DistrictEntity;

@Service
public interface DistrictService {
    DistrictEntity addDistrict(DistrictDto districtDto);
    List<DistrictEntity> getAllDistricts();
    DistrictEntity getDistrictsById(Long id);
    List<DistrictEntity> getDistrictsByProvince(Long id);
}
