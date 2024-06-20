package com.travelmate.travelmate.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityRatingDto {
    private Long id;
    private Double rate;
    private String comment;
    private Long userId;
    private Long cityId;
}
