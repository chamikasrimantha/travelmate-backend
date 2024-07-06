package com.travelmate.travelmate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travelmate.travelmate.dto.AdminDto;
import com.travelmate.travelmate.dto.PartnerDto;
import com.travelmate.travelmate.dto.UserDto;
import com.travelmate.travelmate.dto.UserPwdDto;
import com.travelmate.travelmate.entity.Admin;
import com.travelmate.travelmate.entity.Partner;
import com.travelmate.travelmate.entity.User;
import com.travelmate.travelmate.entity.UserEntity;
import com.travelmate.travelmate.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public UserEntity createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @PostMapping("/partners")
    public UserEntity createPartner(@RequestBody PartnerDto partnerDto){
        return userService.createPartner(partnerDto);
    }

    @PostMapping("/admins")
    public UserEntity createAdmin(@RequestBody AdminDto adminDto){
        return userService.createAdmin(adminDto);
    }

    @PutMapping("/users/{id}")
    public UserEntity updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        return userService.updateUser(id, userDto);
    }

    @PutMapping("/partners/{id}")
    public UserEntity updatePartner(@PathVariable Long id, @RequestBody PartnerDto partnerDto){
        return userService.updatePartner(id, partnerDto);
    }

    @PutMapping("/admins/{id}")
    public UserEntity updateAdmin(@PathVariable Long id, @RequestBody AdminDto adminDto){
        return userService.updateAdmin(id, adminDto);
    }

    @PutMapping("/users/{id}/change-password")
    public UserEntity changeUserPassword(@PathVariable Long id, @RequestBody UserPwdDto userPwdDto){
        return userService.changeUserPassword(id, userPwdDto);
    }

    @PutMapping("/partners/{id}/change-password")
    public UserEntity changePartnerPassword(@PathVariable Long id, @RequestBody UserPwdDto userPwdDto){
        return userService.changePartnerPassword(id, userPwdDto);
    }

    @PutMapping("/admins/{id}/change-password")
    public UserEntity changeAdminPassword(@PathVariable Long id, @RequestBody UserPwdDto userPwdDto){
        return userService.changeAdminPassword(id, userPwdDto);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/partners")
    public List<Partner> getAllPartners() {
        return userService.getAllPartners();
    }

    @GetMapping("/admins")
    public List<Admin> getAllAdmins() {
        return userService.getAllAdmins();
    }

    @GetMapping("/users/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    
}
