package com.vitali.animal.service;

import com.vitali.animal.dto.AnimalDto;
import com.vitali.animal.dto.CreateAnimalDto;
import com.vitali.animal.entity.Animal;

import java.util.List;

public interface Service {

    List<AnimalDto> findAll();

    AnimalDto findById(Integer id);

    Animal save(CreateAnimalDto createAnimalDto);

    void update(CreateAnimalDto createAnimalDto, Integer id);

    void delete(Integer id);
}
