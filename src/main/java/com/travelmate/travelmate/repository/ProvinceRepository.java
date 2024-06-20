package com.travelmate.travelmate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelmate.travelmate.entity.ProvinceEntity;

@Repository
public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Long>{
    
}
