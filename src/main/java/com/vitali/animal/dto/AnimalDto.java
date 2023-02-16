package com.vitali.animal.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AnimalDto {
    Integer id;
    String name;
    Integer weight;
}
