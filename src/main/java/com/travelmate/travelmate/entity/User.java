package com.travelmate.travelmate.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends UserEntity {

    private String firstName;

    private String lastName;

    private String phoneNo;

    private String address;

    // relationships

    // one-to-many with city rating entity
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<CityRatingEntity> cityRatings;

    // one-to-many with property rating entity
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<PropertyRatingEntity> propertyRatings;

    // one-to-many with booking entity
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<BookingEntity> bookings;

    // one-to-many with chat entity
    // @JsonIgnore
    // @OneToMany(fetch = FetchType.LAZY, mappedBy = "userEntity", cascade = CascadeType.ALL)
    // private List<ChatEntity> chats;

}
