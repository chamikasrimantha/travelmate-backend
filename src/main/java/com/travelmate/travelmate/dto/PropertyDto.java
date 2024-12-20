package com.travelmate.travelmate.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDto {
    private Long id;
    private String name;
    private String email;
    private String hotline;
    private String location;
    private String sentence;
    private String description;
    private String img;
    private Double price;
    // bedrooms
    private Long bedrooms;
    private Long guests;
    // services
    private Boolean airconditioning;
    private Boolean heating;
    private Boolean wifi;
    private Boolean kitchen;
    private Boolean breakfast;
    private Boolean washingmachine;
    private Boolean tv;
    private Boolean swimmingpool;
    private Boolean hottub;
    private Boolean balcony;
    private Boolean parking;
    private Boolean terrace;
    // rules
    private String checkin;
    private String checkout;
    private Boolean agerestriction;
    private Boolean smoking;
    private Boolean pets;
    private Boolean parties;
    private String paymentMethods;
    // host profile - owner
    private String firstName;
    private String lastName;
    private String businessName;
    private String livingAddress;
    private String phoneNo;
    private String emailAddress;
    // status - VERIFIED - NOT VERIFIED
    private String status;
    //relationships
    private Long userId;
    private Long categoryId;
    private Long districtId;
    private Long cityId;
}
