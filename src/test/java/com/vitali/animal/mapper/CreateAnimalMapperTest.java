package com.vitali.animal.mapper;

import com.vitali.animal.dto.CreateAnimalDto;
import com.vitali.animal.entity.Animal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CreateAnimalMapperTest {
    private final CreateAnimalMapper mapper = CreateAnimalMapper.getInstance();

    @Test
    void mapFrom() {
        CreateAnimalDto dto = CreateAnimalDto.builder()
                .name("Jack")
                .weight(8)
                .build();

        Animal actualResult = mapper.mapFrom(dto);

        Animal expectetResult = Animal.builder()
                .name("Jack")
                .weight(8)
                .build();
        assertThat(actualResult).isEqualTo(expectetResult);
    }
}