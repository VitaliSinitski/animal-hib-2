package com.vitali.animal.mapper;

import com.vitali.animal.dto.AnimalDto;
import com.vitali.animal.entity.Animal;

public class AnimalMapper implements Mapper<Animal, AnimalDto> {
    private static final AnimalMapper INSTANCE = new AnimalMapper();
    @Override
    public AnimalDto mapFrom(Animal object) {
        return AnimalDto.builder()
                .id(object.getId())
                .name(object.getName())
                .weight(object.getWeight())
                .build();
    }
    public static AnimalMapper getInstance() {
        return INSTANCE;
    }
}
