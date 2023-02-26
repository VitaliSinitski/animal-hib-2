package com.vitali.animal.util;

import com.vitali.animal.dto.AnimalDto;
import com.vitali.animal.entity.Animal;

public class Util {
    public static AnimalDto getCreateAnimalDto() {
        return AnimalDto.builder()
                .name("Jack")
                .weight(8)
                .build();
    }

    public static AnimalDto getAnimalDto() {
        return AnimalDto.builder()
                .id(99)
                .name("Jack")
                .weight(8)
                .build();
    }

    public static Animal getAnimal() {
        return Animal.builder()
                .id(99)
                .name("Jack")
                .weight(8)
                .build();
    }
}
