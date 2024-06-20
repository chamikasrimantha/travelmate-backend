package com.travelmate.travelmate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travelmate.travelmate.entity.CityEntity;
import com.travelmate.travelmate.entity.DistrictEntity;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long>{
    @Query("SELECT p FROM CityEntity p WHERE p.districtEntity = :districtEntity")
    List<CityEntity> findCitiesByDistrict(@Param("districtEntity") DistrictEntity districtEntity);
}
