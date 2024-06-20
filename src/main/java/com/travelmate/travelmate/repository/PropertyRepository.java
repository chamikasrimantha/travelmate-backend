package com.travelmate.travelmate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travelmate.travelmate.entity.CategoryEntity;
import com.travelmate.travelmate.entity.CityEntity;
import com.travelmate.travelmate.entity.DistrictEntity;
import com.travelmate.travelmate.entity.PropertyEntity;
import com.travelmate.travelmate.entity.UserEntity;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {
    @Query("SELECT p FROM PropertyEntity p WHERE p.userEntity = :userEntity")
    List<PropertyEntity> findPropertiesByPartner(@Param("userEntity") UserEntity userEntity);

    @Query("SELECT q FROM PropertyEntity q WHERE q.categoryEntity = :categoryEntity")
    List<PropertyEntity> findPropertiesByCategory(@Param("categoryEntity") CategoryEntity categoryEntity);

    @Query("SELECT r FROM PropertyEntity r WHERE r.districtEntity = :districtEntity")
    List<PropertyEntity> findPropertiesByDistrict(@Param("districtEntity") DistrictEntity districtEntity);

    @Query("SELECT s FROM PropertyEntity s WHERE s.cityEntity = :cityEntity")
    List<PropertyEntity> findPropertiesByCity(@Param("cityEntity") CityEntity cityEntity);
}
