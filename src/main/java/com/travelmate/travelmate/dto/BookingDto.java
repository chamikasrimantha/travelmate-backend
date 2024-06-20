package com.travelmate.travelmate.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDto {
    private Long id;
    private Date checkinDate;
    private Date checkoutDate;
    private Double totalPrice;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNo;
    private String bookingFor;
    private String rentingAdditionals;
    private String specialRequests;
    private Time arrivalTime;
    private String paymentMethod;
    private Long userId;
    private Long propertyId;
}
