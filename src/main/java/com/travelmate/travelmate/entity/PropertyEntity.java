package com.travelmate.travelmate.entity;

import java.sql.Blob;
import java.sql.Time;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "propertyId")
    private Long id;

    private String name;

    private String email;

    private String hotline;

    private String location;

    private String sentence;

    private String description;

    @Lob
    private Blob img;

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
    private Time checkin;

    private Time checkout;

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
    
    // relationships

    // one-to-many with partner announcement entity
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "propertyEntity", cascade = CascadeType.ALL)
    private List<PartnerAnnouncementEntity> partnerAnnouncements;

    // one-to-many with property rating entity
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "propertyEntity", cascade = CascadeType.ALL)
    private List<PropertyRatingEntity> propertyRatings;

    // one-to-many with booking entity
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "propertyEntity", cascade = CascadeType.ALL)
    private List<BookingEntity> bookings;

    // one-to-many with chat entity
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "propertyEntity", cascade = CascadeType.ALL)
    private List<ChatEntity> chats;

    // many-to-one with category entity
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private CategoryEntity categoryEntity;

    // many-to-one with partner entity
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

    // many-to-one with district entity
    @ManyToOne
    @JoinColumn(name = "districtId")
    private DistrictEntity districtEntity;

    // many-to-one with city entity
    @ManyToOne
    @JoinColumn(name = "cityId")
    private CityEntity cityEntity;

}
