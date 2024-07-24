package com.travelmate.travelmate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travelmate.travelmate.entity.PartnerAnnouncementEntity;
import com.travelmate.travelmate.entity.PropertyEntity;
import com.travelmate.travelmate.entity.UserEntity;

@Repository
public interface PartnerAnnouncementRepository extends JpaRepository<PartnerAnnouncementEntity, Long>{
    @Query("SELECT p FROM PartnerAnnouncementEntity p WHERE p.propertyEntity = :propertyEntity")
    List<PartnerAnnouncementEntity> findPartnerAnnouncementsByProperty(@Param("propertyEntity") PropertyEntity propertyEntity);

    @Query("SELECT p FROM PartnerAnnouncementEntity p WHERE p.userEntity = :userEntity")
    List<PartnerAnnouncementEntity> findPartnerAnnouncementsByUser(@Param("userEntity") UserEntity userEntity);
}
