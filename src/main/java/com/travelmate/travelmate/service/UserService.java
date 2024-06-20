package com.travelmate.travelmate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.AdminDto;
import com.travelmate.travelmate.dto.PartnerDto;
import com.travelmate.travelmate.dto.UserDto;
import com.travelmate.travelmate.dto.UserPwdDto;
import com.travelmate.travelmate.entity.UserEntity;

@Service
public interface UserService {
    UserEntity createUser(UserDto userDto);

    UserEntity createPartner(PartnerDto partnerDTO);
    
    UserEntity createAdmin(AdminDto adminDTO);

    UserEntity updateUser(UserEntity userEntity);

    UserEntity getUserById(Long id);

    List<UserEntity> getAllUsers();

    UserEntity changePassword(Long id, UserPwdDto userPwdDto);
}
