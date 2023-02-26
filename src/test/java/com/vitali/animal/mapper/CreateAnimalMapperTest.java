package com.vitali.animal.mapper;

import com.vitali.animal.dto.AnimalDto;
import com.vitali.animal.entity.Animal;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CreateAnimalMapperTest {
    private final AnimalMapper mapper = AnimalMapper.getInstance();

    @Test
    void mapFrom() {
        AnimalDto dto = AnimalDto.builder()
                .name("Jack")
                .weight(8)
                .build();

        Animal actualResult = mapper.mapToEntity(dto);

        Animal expectetResult = Animal.builder()
                .name("Jack")
                .weight(8)
                .build();
        assertThat(actualResult).isEqualTo(expectetResult);
    }
}