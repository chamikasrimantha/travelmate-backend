package com.travelmate.travelmate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.AdminDto;
import com.travelmate.travelmate.dto.PartnerDto;
import com.travelmate.travelmate.dto.UserDto;
import com.travelmate.travelmate.dto.UserPwdDto;
import com.travelmate.travelmate.entity.Admin;
import com.travelmate.travelmate.entity.Partner;
import com.travelmate.travelmate.entity.User;
import com.travelmate.travelmate.entity.UserEntity;

@Service
public interface UserService {
    UserEntity createUser(UserDto userDto);
    UserEntity createPartner(PartnerDto partnerDto);
    UserEntity createAdmin(AdminDto adminDtO);
    UserEntity getUserById(Long id);
    List<User> getAllUsers();
    List<Partner> getAllPartners();
    List<Admin> getAllAdmins();
    UserEntity updateUser(Long id, UserDto userDto);
    UserEntity updatePartner(Long id, PartnerDto partnerDto);
    UserEntity updateAdmin(Long id, AdminDto adminDto);
    UserEntity changeUserPassword(Long id, UserPwdDto userPwdDto);
    UserEntity changePartnerPassword(Long id, UserPwdDto userPwdDto);
    UserEntity changeAdminPassword(Long id, UserPwdDto userPwdDto);
}
