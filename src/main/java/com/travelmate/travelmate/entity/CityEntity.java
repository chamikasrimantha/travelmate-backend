package com.travelmate.travelmate.entity;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cityId")
    private Long id;

    private String name;

    private String postcode;

    private Double latitude;

    private Double longitude;

    // relationships

    // one-to-many with property entity
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cityEntity", cascade = CascadeType.ALL)
    private List<PropertyEntity> properties;

    // one-to-many with city rating entity
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cityEntity", cascade = CascadeType.ALL)
    private List<CityRatingEntity> cityratings;

    // many-to-one with district entity
    @ManyToOne
    @JoinColumn(name = "districtId")
    private DistrictEntity districtEntity;

}
