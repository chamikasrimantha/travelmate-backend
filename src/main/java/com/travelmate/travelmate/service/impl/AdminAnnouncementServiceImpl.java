package com.travelmate.travelmate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelmate.travelmate.entity.AdminAnnouncementEntity;
import com.travelmate.travelmate.repository.AdminAnnouncementRepository;
import com.travelmate.travelmate.service.AdminAnnouncementService;

@Service
public class AdminAnnouncementServiceImpl implements AdminAnnouncementService{

    @Autowired
    private AdminAnnouncementRepository adminAnnouncementRepository;

    @Override
    public AdminAnnouncementEntity createAdminAnnouncement(AdminAnnouncementEntity adminAnnouncementEntity) {
        return adminAnnouncementRepository.save(adminAnnouncementEntity);
    }

    @Override
    public AdminAnnouncementEntity deleteAdminAnnouncement(Long id) {
        AdminAnnouncementEntity existingAdminAnnouncement = adminAnnouncementRepository.findById(id).orElse(null);
        if (existingAdminAnnouncement!=null) {
            adminAnnouncementRepository.delete(existingAdminAnnouncement);
            return existingAdminAnnouncement;
        } else {
            return null;
        }
    }

    @Override
    public AdminAnnouncementEntity getAdminAnnouncementsById(Long id) {
        return adminAnnouncementRepository.findById(id).orElse(null);
    }

    @Override
    public List<AdminAnnouncementEntity> getAllAdminAnnouncements() {
        return adminAnnouncementRepository.findAll();
    }

    @Override
    public AdminAnnouncementEntity updateAdminAnnouncement(Long id, AdminAnnouncementEntity adminAnnouncementEntity) {
        AdminAnnouncementEntity existingAdminAnnouncement = adminAnnouncementRepository.findById(id).orElse(null);
        if (existingAdminAnnouncement!=null) {
            existingAdminAnnouncement.setTitle(adminAnnouncementEntity.getTitle());
            existingAdminAnnouncement.setMessage(adminAnnouncementEntity.getMessage());
            return adminAnnouncementRepository.save(existingAdminAnnouncement);
        } else {
            return null;
        }
    }
    
}
