package com.travelmate.travelmate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelmate.travelmate.entity.ChatEntity;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity, Long>{
    
}
