package com.travelmate.travelmate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travelmate.travelmate.dto.PartnerAnnouncementDto;
import com.travelmate.travelmate.entity.PartnerAnnouncementEntity;
import com.travelmate.travelmate.service.PartnerAnnouncementService;

@RestController
@CrossOrigin(origins = "*")
public class PartnerAnnouncementController {

    @Autowired
    private PartnerAnnouncementService partnerAnnouncementService;

    @PostMapping("/partner-announcements")
    public ResponseEntity<PartnerAnnouncementEntity> createPartnerAnnouncement(@RequestBody PartnerAnnouncementDto partnerAnnouncementDto){
        try {
            return ResponseEntity.status(200).body(partnerAnnouncementService.createPartnerAnnouncement(partnerAnnouncementDto));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/partner-announcements")
    public ResponseEntity<List<PartnerAnnouncementEntity>> getAllPartnerAnnouncements(){
        List<PartnerAnnouncementEntity> partnerAnnouncementEntities = partnerAnnouncementService.getAllPartnerAnnouncements();
        if (partnerAnnouncementEntities!=null) {
            return ResponseEntity.status(200).body(partnerAnnouncementEntities);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/partner-announcements/{id}")
    public ResponseEntity<PartnerAnnouncementEntity> getPartnerAnnouncementsById(@PathVariable Long id){
        PartnerAnnouncementEntity partnerAnnouncementEntity = partnerAnnouncementService.getPartnerAnnouncementsById(id);
        if (partnerAnnouncementEntity!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(partnerAnnouncementEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/properties/{id}/partner-announcements")
    public ResponseEntity<List<PartnerAnnouncementEntity>> getPartnerAnnouncementsByProperty(@PathVariable Long id){
        return ResponseEntity.ok().body(partnerAnnouncementService.getPartnerAnnouncementsByProperty(id));
    }

    @GetMapping("/users/{id}/partner-announcements")
    public ResponseEntity<List<PartnerAnnouncementEntity>> getPartnerAnnouncementsByUser(@PathVariable Long id){
        return ResponseEntity.ok().body(partnerAnnouncementService.getPartnerAnnouncementsByUser(id));
    }

    @PutMapping("/partner-announcements/{id}")
    public PartnerAnnouncementEntity updatePartnerAnnouncement(@PathVariable Long id, @RequestBody PartnerAnnouncementEntity partnerAnnouncementEntity){
        return partnerAnnouncementService.updatePartnerAnnouncement(id, partnerAnnouncementEntity);
    }

    @DeleteMapping("/partner-announcements/{id}")
    public PartnerAnnouncementEntity deletePartnerAnnouncement(@PathVariable Long id){
        return partnerAnnouncementService.deletePartnerAnnouncement(id);
    }
    
}
