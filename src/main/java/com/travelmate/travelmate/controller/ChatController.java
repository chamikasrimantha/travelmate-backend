package com.travelmate.travelmate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/chat/sender/{id}")
    public ResponseEntity<List<ChatEntity>> getMessagesBySender(@PathVariable Long id) {
        List<ChatEntity> messages = chatService.getMessagesBySender(id);
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/chat/receiver/{id}")
    public ResponseEntity<List<ChatEntity>> getMessagesByReceiver(@PathVariable Long id) {
        List<ChatEntity> messages = chatService.getMessagesByReceiver(id);
        return ResponseEntity.ok(messages);
    }

}
