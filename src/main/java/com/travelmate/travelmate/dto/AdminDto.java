package com.travelmate.travelmate.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String role;
    private String name;
}
