package com.travelmate.travelmate.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelmate.travelmate.entity.AdminAnnouncementEntity;

@Repository
public interface AdminAnnouncementRepository extends JpaRepository<AdminAnnouncementEntity, Long>{
    
}
