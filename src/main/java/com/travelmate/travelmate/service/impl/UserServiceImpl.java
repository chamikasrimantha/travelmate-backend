package com.travelmate.travelmate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
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

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRole(UserRole.USER);
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPhoneNo(user.getPhoneNo());
        newUser.setAddress(user.getAddress());

        User savedUser = userRepository.save(newUser);

        // Send email
        try {
            sendUserRegistrationEmail(savedUser);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return savedUser;
    }

    private void sendUserRegistrationEmail(UserEntity userEntity) throws MessagingException {
        if (userEntity instanceof User) {
            User user = (User) userEntity;
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            String htmlMsg = "<div style='font-family: Arial, sans-serif; max-width: 600px; margin: auto; padding: 20px; border: 1px solid #ccc;'>"
                    +
                    "<h2 style='color: #4CAF50;'>Welcome to TravelMate.lk</h2>" +
                    "<p>Dear " + user.getFirstName() + " " + user.getLastName() + ",</p>" +
                    "<p>Thank you for registering. Your username is: <strong>" + user.getUsername() + "</strong></p>" +
                    "<p>We're excited to have you on board. Here's what you can do next:</p>" +
                    "<ul>" +
                    "<li><a href='#' style='color: #4CAF50;'>Complete your profile</a></li>" +
                    "<li><a href='#' style='color: #4CAF50;'>Explore top properties</a></li>" +
                    "<li><a href='#' style='color: #4CAF50;'>Contact support</a></li>" +
                    "</ul>" +
                    "<p>If you have any questions, feel free to visit our <a href='#' style='color: #4CAF50;'>help center</a>.</p>"
                    +
                    "<p>Best regards,<br>TravelMate Team</p>" +
                    "<hr>" +
                    "<p style='font-size: 12px; color: #777;'>This is an automated message, please do not reply.</p>" +
                    "</div>";

            helper.setTo(user.getEmail());
            helper.setSubject("Registration Successful");
            helper.setText(htmlMsg, true);
            helper.setFrom("tech1234music@gmail.com");

            javaMailSender.send(mimeMessage);
        }
    }

    @Override
    public UserEntity createAdmin(Admin admin) {
        Admin newAdmin = new Admin();
        newAdmin.setUsername(admin.getUsername());
        newAdmin.setEmail(admin.getEmail());
        newAdmin.setPassword(passwordEncoder.encode(admin.getPassword()));
        newAdmin.setRole(UserRole.ADMIN);
        newAdmin.setName(admin.getName());
        // email
        return userRepository.save(newAdmin);
    }

    @Override
    public UserEntity createPartner(Partner partner) {
        Partner newPartner = new Partner();
        newPartner.setUsername(partner.getUsername());
        newPartner.setEmail(partner.getEmail());
        newPartner.setPassword(passwordEncoder.encode(partner.getPassword()));
        newPartner.setRole(UserRole.PARTNER);
        newPartner.setFirstName(partner.getFirstName());
        newPartner.setLastName(partner.getLastName());
        newPartner.setPhoneNo(partner.getPhoneNo());
        newPartner.setAddress(partner.getAddress());

        UserEntity savedPartner = userRepository.save(newPartner);

        // Send email
        try {
            sendPartnerRegistrationEmail(savedPartner);
        } catch (MessagingException e) {
            e.printStackTrace(); // Handle the exception as needed
        }

        return savedPartner;
    }

    private void sendPartnerRegistrationEmail(UserEntity userEntity) throws MessagingException {
        if (userEntity instanceof User) {
            Partner partner = (Partner) userEntity;
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            String htmlMsg = "<div style='font-family: Arial, sans-serif; max-width:600px; margin: auto; padding: 20px; border: 1px solid #ccc;'>"
                    +
                    "<h2 style='color: #4CAF50;'>Welcome to TravelMate.lk</h2>" +
                    "<p>Dear " + partner.getFirstName() + " " + partner.getLastName() + ",</p>" +
                    "<p>Thank you for registering. Your username is: <strong>" +
                    partner.getUsername() + "</strong></p>"
                    +
                    "<p>We're excited to have you on board. Here's what you can do next:</p>" +
                    "<ul>" +
                    "<li><a href='#' style='color: #4CAF50;'>Complete your profile</a></li>" +
                    "<li><a href='#' style='color: #4CAF50;'>Explore top properties</a></li>" +
                    "<li><a href='#' style='color: #4CAF50;'>Contact support</a></li>" +
                    "</ul>" +
                    "<p>If you have any questions, feel free to visit our <a href='#' style='color: #4CAF50;'>help center</a>.</p>"
                    +
                    "<p>Best regards,<br>TravelMate Team</p>" +
                    "<hr>" +
                    "<p style='font-size: 12px; color: #777;'>This is an automated message, please do not reply.</p>" +
                    "</div>";

            helper.setTo(partner.getEmail());
            helper.setSubject("Registration Successful");
            helper.setText(htmlMsg, true);
            helper.setFrom("tech1234music@gmail.com");

            javaMailSender.send(mimeMessage);
        }
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
        UserEntity existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null && existingUser instanceof User) {
            existingUser.setPassword(userPwdDto.getPassword());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

}