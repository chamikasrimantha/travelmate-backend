package com.travelmate.travelmate.dto;

import java.sql.Date;

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
    private Boolean airportShuttle;
    private Boolean rentingCar;
    private Boolean rentingBicycle;
    private String specialRequests;
    private String arrivalTime;
    private String paymentMethod;
    private Long userId;
    private Long propertyId;
}
