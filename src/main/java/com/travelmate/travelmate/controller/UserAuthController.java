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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travelmate.travelmate.dto.AuthResponse;
import com.travelmate.travelmate.dto.LoginDto;
import com.travelmate.travelmate.entity.Admin;
import com.travelmate.travelmate.entity.Partner;
import com.travelmate.travelmate.entity.User;
import com.travelmate.travelmate.repository.UserRepository;
import com.travelmate.travelmate.security.UserDetailsImpl;
import com.travelmate.travelmate.security.jwt.JwtUtils;
import com.travelmate.travelmate.service.UserService;

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
    public ResponseEntity<?> userLogin(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Long userId = userDetails.getId();
        return ResponseEntity.ok().body(new AuthResponse(token, userId));
    }

    @PostMapping("/auth/partner/login")
    public ResponseEntity<?> partnerLogin(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Long userId = userDetails.getId();
        return ResponseEntity.ok().body(new AuthResponse(token, userId));
    }

    @PostMapping("/auth/admin/login")
    public ResponseEntity<?> adminLogin(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtils.generateJwtToken(authentication);
        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/auth/user/register")
    public ResponseEntity<?> userRegister(@RequestBody User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().body("Username is already in use");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("Email is already in use");
        }
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PostMapping("/auth/partner/register")
    public ResponseEntity<?> partnerRegister(@RequestBody Partner partner) {
        if (userRepository.existsByUsername(partner.getUsername())) {
            return ResponseEntity.badRequest().body("Username is already in use");
        }
        if (userRepository.existsByEmail(partner.getEmail())) {
            return ResponseEntity.badRequest().body("Email is already in use");
        }
        return ResponseEntity.ok(userService.createPartner(partner));
    }

    @PostMapping("/auth/admin/register")
    public ResponseEntity<?> adminRegister(@RequestBody Admin admin) {
        if (userRepository.existsByUsername(admin.getUsername())) {
            return ResponseEntity.badRequest().body("Username is already in use");
        }
        if (userRepository.existsByEmail(admin.getEmail())) {
            return ResponseEntity.badRequest().body("Email is already in use");
        }
        return ResponseEntity.ok(userService.createAdmin(admin));
    }

}
