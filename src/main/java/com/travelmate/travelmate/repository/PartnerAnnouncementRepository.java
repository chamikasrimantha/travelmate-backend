package com.travelmate.travelmate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travelmate.travelmate.entity.PartnerAnnouncementEntity;
import com.travelmate.travelmate.entity.PropertyEntity;

@Repository
public interface PartnerAnnouncementRepository extends JpaRepository<PartnerAnnouncementEntity, Long>{
    @Query("SELECT p FROM PartnerAnnouncementEntity p WHERE p.propertyEntity = :propertyEntity")
    List<PartnerAnnouncementEntity> findPartnerAnnouncementsByProperty(@Param("propertyEntity") PropertyEntity propertyEntity);
}
