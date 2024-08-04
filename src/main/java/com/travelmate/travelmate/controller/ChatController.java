package com.travelmate.travelmate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelmate.travelmate.dto.ChatDto;
import com.travelmate.travelmate.entity.ChatEntity;
import com.travelmate.travelmate.service.ChatService;

@RestController
@CrossOrigin(origins = "*")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/chat/send")
    public ResponseEntity<ChatEntity> sendMessage(@RequestBody ChatDto chatDto) {
        ChatEntity chatEntity = chatService.sendMessage(chatDto);
        return ResponseEntity.ok(chatEntity);
    }

    @GetMapping("/chat/sender/{senderId}")
    public ResponseEntity<List<ChatEntity>> getMessagesBySender(@PathVariable Long senderId) {
        List<ChatEntity> messages = chatService.getMessagesBySender(senderId);
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/chat/receiver/{receiverId}")
    public ResponseEntity<List<ChatEntity>> getMessagesByReceiver(@PathVariable Long receiverId) {
        List<ChatEntity> messages = chatService.getMessagesByReceiver(receiverId);
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/chat/conversation")
    public ResponseEntity<List<ChatEntity>> getAllMessages(
            @RequestParam Long senderId,
            @RequestParam Long receiverId) {
        List<ChatEntity> messages = chatService.getAllMessages(senderId, receiverId);
        return ResponseEntity.ok(messages);
    }

}
