package com.travelmate.travelmate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travelmate.travelmate.entity.CityEntity;
import com.travelmate.travelmate.entity.CityRatingEntity;
import com.travelmate.travelmate.entity.UserEntity;

@Repository
public interface CityRatingRepository extends JpaRepository<CityRatingEntity, Long>{
    @Query("SELECT p FROM CityRatingEntity p WHERE p.userEntity = :userEntity")
    List<CityRatingEntity> findCityRatingsByUser(@Param("userEntity") UserEntity userEntity);

    @Query("SELECT q FROM CityRatingEntity q WHERE q.cityEntity = :cityEntity")
    List<CityRatingEntity> findCityRatingsByCity(@Param("cityEntity") CityEntity cityEntity);
}
