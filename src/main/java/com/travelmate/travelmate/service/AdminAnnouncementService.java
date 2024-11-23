package com.travelmate.travelmate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelmate.travelmate.entity.AdminAnnouncementEntity;

@Service
public interface AdminAnnouncementService {
    AdminAnnouncementEntity createAdminAnnouncement(AdminAnnouncementEntity adminAnnouncementEntity);
    List<AdminAnnouncementEntity> getAllAdminAnnouncements();
    AdminAnnouncementEntity getAdminAnnouncementsById(Long id);
    AdminAnnouncementEntity updateAdminAnnouncement(Long id, AdminAnnouncementEntity adminAnnouncementEntity);
    AdminAnnouncementEntity deleteAdminAnnouncement(Long id);
}
