package com.travelmate.travelmate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.ChatDto;
import com.travelmate.travelmate.entity.ChatEntity;

@Service
public interface ChatService {
    ChatEntity sendMessage(ChatDto chatDto);
    List<ChatEntity> getMessagesBySender(Long id);
    List<ChatEntity> getMessagesByReceiver(Long id);
}
