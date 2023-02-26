package com.vitali.animal.mapper;

import com.vitali.animal.dto.AnimalDto;
import com.vitali.animal.entity.Animal;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AnimalMapperTest {
    private final AnimalMapper mapper = AnimalMapper.getInstance();
    @Test
    void mapFrom() {
        Animal animal = Animal.builder()
                .id(99)
                .name("Jack")
                .weight(8)
                .build();

        AnimalDto actualResult = mapper.mapToDto(animal);

        AnimalDto expectetResult = AnimalDto.builder()
                .id(99)
                .name("Jack")
                .weight(8)
                .build();
        assertThat(actualResult).isEqualTo(expectetResult);
    }
}