package com.vitali.animal.service;

import com.vitali.animal.dao.AnimalDao;
import com.vitali.animal.dto.AnimalDto;
import com.vitali.animal.dto.CreateAnimalDto;
import com.vitali.animal.entity.Animal;
import com.vitali.animal.mapper.AnimalMapper;
import com.vitali.animal.mapper.CreateAnimalMapper;
import com.vitali.animal.validator.CreateAnimalValidator;
import com.vitali.animal.validator.ValidationResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {
    @Mock
    private CreateAnimalValidator createAnimalValidator;
    @Mock
    private AnimalDao animalDao;
    @Mock
    private CreateAnimalMapper createAnimalMapper;
    @Mock
    private AnimalMapper animalMapper;
    @InjectMocks
    private AnimalService animalService;

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
        CreateAnimalDto createAnimalDto = getCreateAnimalDto();
        Animal animal = getAnimal();
        AnimalDto animalDto = getAnimalDto();
        doReturn(new ValidationResult()).when(createAnimalValidator).isValid(createAnimalDto);
        doReturn(animal).when(createAnimalMapper).mapFrom(createAnimalDto);
        doReturn(animalDto).when(animalMapper).mapFrom(animal);

        AnimalDto actualResult = animalService.save(createAnimalDto);

        assertThat(actualResult).isEqualTo(animalDto);
        verify(animalDao.save(animal));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private CreateAnimalDto getCreateAnimalDto() {
        return CreateAnimalDto.builder()
                .name("Jack")
                .weight(8)
                .build();
    }

    private static AnimalDto getAnimalDto() {
        return AnimalDto.builder()
                .id(99)
                .name("Jack")
                .weight(8)
                .build();
    }

    private Animal getAnimal() {
        return Animal.builder()
                .id(99)
                .name("Jack")
                .weight(8)
                .build();
    }
}