package com.travelmate.travelmate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.PartnerAnnouncementDto;
import com.travelmate.travelmate.entity.PartnerAnnouncementEntity;

@Service
public interface PartnerAnnouncementService {
    PartnerAnnouncementEntity createPartnerAnnouncement(PartnerAnnouncementDto partnerAnnouncementDto);
    List<PartnerAnnouncementEntity> getAllPartnerAnnouncements();
    PartnerAnnouncementEntity getPartnerAnnouncementsById(Long id);
    List<PartnerAnnouncementEntity> getPartnerAnnouncementsByProperty(Long id);
    PartnerAnnouncementEntity updatePartnerAnnouncement(Long id, PartnerAnnouncementEntity partnerAnnouncementEntity);
    PartnerAnnouncementEntity deletePartnerAnnouncement(Long id);
}
