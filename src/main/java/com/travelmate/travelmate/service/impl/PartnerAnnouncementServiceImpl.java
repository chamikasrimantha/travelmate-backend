package com.travelmate.travelmate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.PartnerAnnouncementDto;
import com.travelmate.travelmate.entity.PartnerAnnouncementEntity;
import com.travelmate.travelmate.entity.PropertyEntity;
import com.travelmate.travelmate.repository.PartnerAnnouncementRepository;
import com.travelmate.travelmate.repository.PropertyRepository;
import com.travelmate.travelmate.service.PartnerAnnouncementService;

@Service
public class PartnerAnnouncementServiceImpl implements PartnerAnnouncementService {

    @Autowired
    private PartnerAnnouncementRepository partnerAnnouncementRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public PartnerAnnouncementEntity createPartnerAnnouncement(PartnerAnnouncementDto partnerAnnouncementDto) {
        PropertyEntity propertyEntity = propertyRepository.findById(partnerAnnouncementDto.getPropertyId()).orElse(null);
        if (propertyEntity!=null) {
            PartnerAnnouncementEntity partnerAnnouncementEntity = new PartnerAnnouncementEntity();
            partnerAnnouncementEntity.setTitle(partnerAnnouncementDto.getTitle());
            partnerAnnouncementEntity.setMessage(partnerAnnouncementDto.getMessage());
            partnerAnnouncementEntity.setPropertyEntity(propertyEntity);
            return partnerAnnouncementRepository.save(partnerAnnouncementEntity);
        } else {
            return null;
        }
    }

    @Override
    public PartnerAnnouncementEntity deletePartnerAnnouncement(Long id) {
        PartnerAnnouncementEntity existingPartnerAnnouncement = partnerAnnouncementRepository.findById(id).orElse(null);
        if (existingPartnerAnnouncement!=null) {
            partnerAnnouncementRepository.delete(existingPartnerAnnouncement);
            return existingPartnerAnnouncement;
        } else {
            return null;
        }
    }

    @Override
    public List<PartnerAnnouncementEntity> getAllPartnerAnnouncements() {
        return partnerAnnouncementRepository.findAll();
    }

    @Override
    public PartnerAnnouncementEntity getPartnerAnnouncementsById(Long id) {
        return partnerAnnouncementRepository.findById(id).orElse(null);
    }

    @Override
    public List<PartnerAnnouncementEntity> getPartnerAnnouncementsByProperty(Long id) {
        PropertyEntity propertyEntity = propertyRepository.findById(id).orElse(null);
        if (propertyEntity!=null) {
            return partnerAnnouncementRepository.findPartnerAnnouncementsByProperty(propertyEntity);
        } else {
            return null;
        }
    }

    @Override
    public PartnerAnnouncementEntity updatePartnerAnnouncement(Long id,
            PartnerAnnouncementEntity partnerAnnouncementEntity) {
        PartnerAnnouncementEntity existingPartnerAnnouncement = partnerAnnouncementRepository.findById(id).orElse(null);
        if (existingPartnerAnnouncement!=null) {
            existingPartnerAnnouncement.setTitle(partnerAnnouncementEntity.getTitle());
            existingPartnerAnnouncement.setMessage(partnerAnnouncementEntity.getMessage());
            return partnerAnnouncementRepository.save(existingPartnerAnnouncement);
        } else {
            return null;
        }
    }

}
