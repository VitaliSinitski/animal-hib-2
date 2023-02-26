package com.vitali.animal.service;

import com.vitali.animal.dto.AnimalDto;

import java.util.List;

public interface Service {

    List<AnimalDto> findAll();

    AnimalDto findById(Integer id);

    void delete(Integer id);

    void update(AnimalDto animalDto, Integer id);

    AnimalDto save(AnimalDto animalDto);

}
