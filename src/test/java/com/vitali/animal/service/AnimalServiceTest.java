package com.vitali.animal.service;

import com.vitali.animal.dao.AnimalDao;
import com.vitali.animal.mapper.AnimalMapper;
import com.vitali.animal.validator.CreateAnimalValidator;
import org.junit.jupiter.api.Test;

import static com.vitali.animal.util.Util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class AnimalServiceTest {

    private CreateAnimalValidator createAnimalValidator;
    private AnimalDao animalDao;
    private AnimalMapper animalMapper;
    private AnimalService animalService = AnimalService.getInstance();

    @Test
    void findAll() {
        assertNotNull(animalService.findAll());
    }

    @Test
    void findById() {
//        AnimalDto animalDto = getAnimalDto();
//        Integer id = animalDto.getId();
//        AnimalDto expectetResult = animalService.findById(id);
//        assertThat(animalDto).isEqualTo(expectetResult);
    }

    @Test
    void save() {
        assertNotNull(animalService.save(getAnimalDto()));
    }

    @Test
    void update() {

    }

    @Test
    void delete() {
//        CreateAnimalDto createAnimalDto = getCreateAnimalDto();
//        AnimalDto animalDto = animalService.save(createAnimalDto);
//        Integer id = animalDto.getId();
//        animalService.delete(id);
//        assertEquals(1, id);
    }



}