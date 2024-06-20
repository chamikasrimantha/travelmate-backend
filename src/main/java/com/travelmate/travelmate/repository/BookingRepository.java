package com.travelmate.travelmate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travelmate.travelmate.entity.BookingEntity;
import com.travelmate.travelmate.entity.PropertyEntity;
import com.travelmate.travelmate.entity.UserEntity;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long>{
    @Query("SELECT p FROM BookingEntity p WHERE p.userEntity = :userEntity")
    List<BookingEntity> findBookingsByUser(@Param("userEntity") UserEntity userEntity);

    @Query("SELECT q FROM BookingEntity q WHERE q.propertyEntity = :propertyEntity")
    List<BookingEntity> findBookingsByProperty(@Param("propertyEntity") PropertyEntity propertyEntity);
}
