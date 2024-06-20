package com.travelmate.travelmate.service;

import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.AdminDto;
import com.travelmate.travelmate.dto.PartnerDto;
import com.travelmate.travelmate.dto.UserDto;
import com.travelmate.travelmate.entity.UserEntity;

@Service
public interface UserService {
    UserEntity createUser(UserDto userDto);
    UserEntity createPartner(PartnerDto partnerDtO);
    UserEntity createAdmin(AdminDto adminDtO);
}
