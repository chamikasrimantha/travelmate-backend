package com.travelmate.travelmate.entity;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@Table(name = "booking")
public class BookingEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingId")
    private Long id;

    // 1st section
    private Date checkinDate;

    private Date checkoutDate;

    private Double totalPrice;

    // 2nd section
    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private String phoneNo;

    private String bookingFor; // mainGuest or someoneElse

    private String rentingAdditionals; // airportShuttle, rentCar, rentBicycle

    private String specialRequests;

    private String arrivalTime;

    // 3rd section - payment

    private String paymentMethod;

    // relationships

    // many-to-one with user entity
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

    // many-to-one with property entity
    @ManyToOne
    @JoinColumn(name = "propertyId")
    private PropertyEntity propertyEntity;

}
