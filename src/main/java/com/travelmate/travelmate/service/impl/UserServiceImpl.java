package com.travelmate.travelmate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.AdminDto;
import com.travelmate.travelmate.dto.PartnerDto;
import com.travelmate.travelmate.dto.UserDto;
import com.travelmate.travelmate.entity.Admin;
import com.travelmate.travelmate.entity.Partner;
import com.travelmate.travelmate.entity.User;
import com.travelmate.travelmate.entity.UserEntity;
import com.travelmate.travelmate.entity.UserRole;
import com.travelmate.travelmate.repository.UserRepository;
import com.travelmate.travelmate.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity createUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(UserRole.USER);
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhoneNo(userDto.getPhoneNo());
        user.setAddress(userDto.getAddress());
        return userRepository.save(user);
    }

    @Override
    public UserEntity createAdmin(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setUsername(adminDto.getUsername());
        admin.setEmail(adminDto.getEmail());
        admin.setPassword(adminDto.getPassword());
        admin.setRole(UserRole.ADMIN);
        admin.setName(adminDto.getName());
        return userRepository.save(admin);
    }

    @Override
    public UserEntity createPartner(PartnerDto partnerDto) {
        Partner partner = new Partner();
        partner.setUsername(partnerDto.getUsername());
        partner.setEmail(partnerDto.getEmail());
        partner.setPassword(partnerDto.getPassword());
        partner.setRole(UserRole.PARTNER);
        partner.setFirstName(partnerDto.getFirstName());
        partner.setLastName(partnerDto.getLastName());
        partner.setPhoneNo(partnerDto.getPhoneNo());
        partner.setAddress(partnerDto.getAddress());
        return userRepository.save(partner);
    }

}