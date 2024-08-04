package com.travelmate.travelmate.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.ChatDto;
import com.travelmate.travelmate.entity.ChatEntity;
import com.travelmate.travelmate.entity.UserEntity;
import com.travelmate.travelmate.repository.ChatRepository;
import com.travelmate.travelmate.repository.UserRepository;
import com.travelmate.travelmate.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ChatEntity sendMessage(ChatDto chatDto) {
        // Fetch sender and receiver entities
        UserEntity sender = userRepository.findById(chatDto.getSenderId())
                .orElseThrow(() -> new RuntimeException("Sender not found"));
        UserEntity receiver = userRepository.findById(chatDto.getReceiverId())
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        // Create and save ChatEntity
        ChatEntity chatEntity = new ChatEntity();
        chatEntity.setSender(sender);
        chatEntity.setReceiver(receiver);
        chatEntity.setMessage(chatDto.getMessage());
        chatEntity.setTimestamp(LocalDateTime.now());

        return chatRepository.save(chatEntity);
    }

    @Override
    public List<ChatEntity> getAllMessages(Long senderId, Long receiverId) {
        // Fetch sender and receiver entities
        UserEntity sender = userRepository.findById(senderId)
                .orElseThrow(() -> new RuntimeException("Sender not found"));
        UserEntity receiver = userRepository.findById(receiverId)
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        return chatRepository.findAllBySenderAndReceiver(sender, receiver);
    }

    @Override
    public List<ChatEntity> getMessagesByReceiver(Long receiverId) {
        // Fetch receiver entity
        UserEntity receiver = userRepository.findById(receiverId)
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        return chatRepository.findAllByReceiver(receiver);
    }

    @Override
    public List<ChatEntity> getMessagesBySender(Long senderId) {
        // Fetch sender entity
        UserEntity sender = userRepository.findById(senderId)
                .orElseThrow(() -> new RuntimeException("Sender not found"));

        return chatRepository.findAllBySender(sender);
    }

}
