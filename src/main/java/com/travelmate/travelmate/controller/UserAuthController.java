package com.travelmate.travelmate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelmate.travelmate.dto.AdminDto;
import com.travelmate.travelmate.dto.LoginDto;
import com.travelmate.travelmate.dto.PartnerDto;
import com.travelmate.travelmate.dto.UserDto;
import com.travelmate.travelmate.entity.Admin;
import com.travelmate.travelmate.entity.Partner;
import com.travelmate.travelmate.entity.User;
import com.travelmate.travelmate.entity.UserRole;
import com.travelmate.travelmate.repository.UserRepository;
import com.travelmate.travelmate.security.jwt.JwtUtils;
import com.travelmate.travelmate.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "*")
public class UserAuthController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/auth/user/login")
    public ResponseEntity<?> userLogin(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtils.generateJwtToken(authentication);
        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/auth/partner/login")
    public ResponseEntity<?> partnerLogin(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtils.generateJwtToken(authentication);
        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/auth/admin/login")
    public ResponseEntity<?> adminLogin(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtils.generateJwtToken(authentication);
        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/auth/user/register")
    public ResponseEntity<?> userRegister(@RequestBody UserDto userDto){
        if (userRepository.existsByUsername(userDto.getUsername())) {
            return ResponseEntity.badRequest().body("Username is already in use");
        }
        if (userRepository.existsByEmail(userDto.getEmail())) {
            return ResponseEntity.badRequest().body("Email is already in use");
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(UserRole.USER);
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhoneNo(userDto.getPhoneNo());
        user.setAddress(userDto.getAddress());
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @PostMapping("/auth/partner/register")
    public ResponseEntity<?> partnerRegister(@RequestBody PartnerDto partnerDto){
        if (userRepository.existsByUsername(partnerDto.getUsername())) {
            return ResponseEntity.badRequest().body("Username is already in use");
        }
        if (userRepository.existsByEmail(partnerDto.getEmail())) {
            return ResponseEntity.badRequest().body("Email is already in use");
        }
        Partner partner = new Partner();
        partner.setUsername(partnerDto.getUsername());
        partner.setEmail(partnerDto.getEmail());
        partner.setPassword(partnerDto.getPassword());
        partner.setRole(UserRole.PARTNER);
        partner.setFirstName(partnerDto.getFirstName());
        partner.setLastName(partnerDto.getLastName());
        partner.setPhoneNo(partnerDto.getPhoneNo());
        partner.setAddress(partnerDto.getAddress());
        return ResponseEntity.ok(userService.createPartner(partnerDto));
    }

    @PostMapping("/auth/admin/register")
    public ResponseEntity<?> adminRegister(@RequestBody AdminDto adminDto){
        if (userRepository.existsByUsername(adminDto.getUsername())) {
            return ResponseEntity.badRequest().body("Username is already in use");
        }
        if (userRepository.existsByEmail(adminDto.getEmail())) {
            return ResponseEntity.badRequest().body("Email is already in use");
        }
        Admin admin = new Admin();
        admin.setUsername(adminDto.getUsername());
        admin.setEmail(adminDto.getEmail());
        admin.setPassword(adminDto.getPassword());
        admin.setRole(UserRole.ADMIN);
        admin.setName(adminDto.getName());
        return ResponseEntity.ok(userService.createAdmin(adminDto));
    }
    
}
