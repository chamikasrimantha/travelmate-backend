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

import com.travelmate.travelmate.entity.AdminAnnouncementEntity;
import com.travelmate.travelmate.service.AdminAnnouncementService;


@RestController
@CrossOrigin(origins = "*")
public class AdminAnnouncementController {

    @Autowired
    private AdminAnnouncementService adminAnnouncementService;

    @PostMapping("/admin-announcements")
    public ResponseEntity<AdminAnnouncementEntity> createAdminAnnouncement(@RequestBody AdminAnnouncementEntity adminAnnouncementEntity){
        try {
            return ResponseEntity.status(200).body(adminAnnouncementService.createAdminAnnouncement(adminAnnouncementEntity));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/admin-announcements")
    public ResponseEntity<List<AdminAnnouncementEntity>> getAllAdminAnnouncements(){
        List<AdminAnnouncementEntity> adminAnnouncementEntities = adminAnnouncementService.getAllAdminAnnouncements();
        if (adminAnnouncementEntities!=null) {
            return ResponseEntity.status(200).body(adminAnnouncementEntities);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/admin-announcements")
    public ResponseEntity<AdminAnnouncementEntity> getAdminAnnouncementsById(@PathVariable Long id){
        AdminAnnouncementEntity adminAnnouncementEntity = adminAnnouncementService.getAdminAnnouncementsById(id);
        if (adminAnnouncementEntity!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(adminAnnouncementEntity);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    @PutMapping("/admin-announcements/{id}")
    public AdminAnnouncementEntity updateAdminAnnouncement(@PathVariable Long id, @RequestBody AdminAnnouncementEntity adminAnnouncementEntity){
        return adminAnnouncementService.updateAdminAnnouncement(id, adminAnnouncementEntity);
    }

    @DeleteMapping("/admin-announcements/{id}")
    public AdminAnnouncementEntity deleteAdminAnnouncement(@PathVariable Long id){
        return adminAnnouncementService.deleteAdminAnnouncement(id);
    }
    
}
