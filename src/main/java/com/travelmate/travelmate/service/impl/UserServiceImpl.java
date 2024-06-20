package com.travelmate.travelmate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelmate.travelmate.dto.AdminDto;
import com.travelmate.travelmate.dto.PartnerDto;
import com.travelmate.travelmate.dto.UserDto;
import com.travelmate.travelmate.dto.UserPwdDto;
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
    public UserEntity changePassword(Long id, UserPwdDto userPwdDto) {
        // TODO Auto-generated method stub
        return null;
    }

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
    public UserEntity createAdmin(AdminDto adminDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserEntity createPartner(PartnerDto partnerDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserEntity getUserById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        // TODO Auto-generated method stub
        return null;
    }


}
