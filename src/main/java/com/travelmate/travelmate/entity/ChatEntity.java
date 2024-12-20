package com.travelmate.travelmate.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class ChatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatId")
    private Long id;

    private String message;

    // relationships

    // many-to-one with user entity
    @ManyToOne
    @JoinColumn(name = "senderId")
    private UserEntity sender;

    // many-to-one with user entity
    @ManyToOne
    @JoinColumn(name = "receiverId")
    private UserEntity receiver;

    private LocalDateTime timestamp;

}
