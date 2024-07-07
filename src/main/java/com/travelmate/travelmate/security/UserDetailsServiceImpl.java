package com.travelmate.travelmate.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.travelmate.travelmate.entity.UserEntity;
import com.travelmate.travelmate.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username).orElse(null);

        if( userEntity == null ) {
            throw new UsernameNotFoundException("User is not found with the username");
        }

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + userEntity.getRole().name());


        return org.springframework.security.core.userdetails.User.builder()
            .username(userEntity.getUsername())
            .password(userEntity.getPassword())
            .authorities(Collections.singletonList(authority))
            .build();
    }
    
}
