package com.travelmate.travelmate.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyRatingDto {
    private Long id;
    private Double rate;
    private String comment;
    private Long userId;
    private Long propertyId;
}
