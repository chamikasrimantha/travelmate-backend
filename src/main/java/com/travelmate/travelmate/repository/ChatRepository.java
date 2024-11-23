package com.travelmate.travelmate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travelmate.travelmate.entity.ChatEntity;
import com.travelmate.travelmate.entity.UserEntity;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity, Long> {

    @Query("SELECT c FROM ChatEntity c WHERE c.sender = :sender")
    List<ChatEntity> findAllBySender(@Param("sender") UserEntity sender);

    @Query("SELECT c FROM ChatEntity c WHERE c.receiver = :receiver")
    List<ChatEntity> findAllByReceiver(@Param("receiver") UserEntity receiver);

    @Query("SELECT c FROM ChatEntity c WHERE c.sender = :sender AND c.receiver = :receiver")
    List<ChatEntity> findAllBySenderAndReceiver(@Param("sender") UserEntity sender, @Param("receiver") UserEntity receiver);
}
