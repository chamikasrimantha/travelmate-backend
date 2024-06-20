package com.travelmate.travelmate.dto;

import java.sql.Blob;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDto {
    private Long id;
    private String name;
    private Blob img;
    private String postCode;
    private Double latitude;
    private Double longitude;
    private Long districtId;
}
