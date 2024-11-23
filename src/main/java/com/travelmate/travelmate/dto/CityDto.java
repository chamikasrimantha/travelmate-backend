package com.travelmate.travelmate.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDto {
    private Long id;
    private String name;
    private String postcode;
    private Double latitude;
    private Double longitude;
    private Long districtId;
}
