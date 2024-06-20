package com.travelmate.travelmate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travelmate.travelmate.entity.DistrictEntity;
import com.travelmate.travelmate.entity.ProvinceEntity;

@Repository
public interface DistrictRepository extends JpaRepository<DistrictEntity, Long>{
    @Query("SELECT p FROM DistrictEntity p WHERE p.provinceEntity = :provinceEntity")
    List<DistrictEntity> findDistrictsByProvince(@Param("provinceEntity") ProvinceEntity provinceEntity);
}
