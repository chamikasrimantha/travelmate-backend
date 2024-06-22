package com.travelmate.travelmate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.AdminDto;
import com.travelmate.travelmate.dto.PartnerDto;
import com.travelmate.travelmate.dto.UserDto;
import com.travelmate.travelmate.dto.UserPwdDto;
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
        // email
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
        // email
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
        // email
        return userRepository.save(partner);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return userRepository.findAdminsByRole(UserRole.ADMIN);
    }

    @Override
    public List<Partner> getAllPartners() {
        return userRepository.findPartnersByRole(UserRole.PARTNER);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findUsersByRole(UserRole.USER);
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserEntity updateUser(Long id, UserDto userDto) {
        UserEntity existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null && existingUser instanceof User) {
            User user = (User) existingUser;
            user.setUsername(userDto.getUsername());
            user.setEmail(userDto.getEmail());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setPhoneNo(userDto.getPhoneNo());
            user.setAddress(userDto.getAddress());
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    @Override
    public UserEntity updateAdmin(Long id, AdminDto adminDto) {
        return null;
    }

    @Override
    public UserEntity updatePartner(Long id, PartnerDto partnerDto) {
        UserEntity existingPartner = userRepository.findById(id).orElse(null);
        if (existingPartner != null && existingPartner instanceof Partner) {
            Partner partner = (Partner) existingPartner;
            partner.setUsername(partnerDto.getUsername());
            partner.setEmail(partnerDto.getEmail());
            partner.setFirstName(partnerDto.getFirstName());
            partner.setLastName(partnerDto.getLastName());
            partner.setPhoneNo(partnerDto.getPhoneNo());
            partner.setAddress(partnerDto.getAddress());
            return userRepository.save(partner);
        } else {
            return null;
        }
    }

    @Override
    public UserEntity changeAdminPassword(Long id, UserPwdDto userPwdDto) {
        UserEntity existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null && existingUser instanceof User) {
            existingUser.setPassword(userPwdDto.getPassword());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

    @Override
    public UserEntity changePartnerPassword(Long id, UserPwdDto userPwdDto) {
        UserEntity existingPartner = userRepository.findById(id).orElse(null);
        if (existingPartner != null && existingPartner instanceof Partner) {
            existingPartner.setPassword(userPwdDto.getPassword());
            return userRepository.save(existingPartner);
        } else {
            return null;
        }
    }

    @Override
    public UserEntity changeUserPassword(Long id, UserPwdDto userPwdDto) {
        return null;
    }

}