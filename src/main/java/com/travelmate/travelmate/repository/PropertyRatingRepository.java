package com.travelmate.travelmate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travelmate.travelmate.entity.PropertyEntity;
import com.travelmate.travelmate.entity.PropertyRatingEntity;
import com.travelmate.travelmate.entity.UserEntity;

@Repository
public interface PropertyRatingRepository extends JpaRepository<PropertyRatingEntity, Long>{
    @Query("SELECT p FROM PropertyRatingEntity p WHERE p.userEntity = :userEntity")
    List<PropertyRatingEntity> findPropertyRatingsByUser(@Param("userEntity") UserEntity userEntity);

    @Query("SELECT q FROM PropertyRatingEntity q WHERE q.propertyEntity = :propertyEntity")
    List<PropertyRatingEntity> findPropertyRatingsByProperty(@Param("propertyEntity") PropertyEntity propertyEntity);
}
