package com.vitali.animal.service;

import com.vitali.animal.dto.AnimalDto;
import com.vitali.animal.dto.CreateAnimalDto;
import com.vitali.animal.entity.Animal;

import java.util.List;

public interface Service {

    List<AnimalDto> findAll();

    AnimalDto findById(Integer id);

    void delete(Integer id);

    void update(CreateAnimalDto createAnimalDto, Integer id);

    AnimalDto save(CreateAnimalDto createAnimalDto);

}
