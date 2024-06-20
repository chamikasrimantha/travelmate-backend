package com.travelmate.travelmate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class PropertyRatingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "propertyratingId")
    private Long id;

    private Double rate;

    private String comment;

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