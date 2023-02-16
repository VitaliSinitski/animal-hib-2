package com.vitali.animal.service;

import com.vitali.animal.dao.AnimalDao;
import com.vitali.animal.dto.AnimalDto;
import com.vitali.animal.dto.CreateAnimalDto;
import com.vitali.animal.entity.Animal;
import com.vitali.animal.mapper.AnimalMapper;
import com.vitali.animal.mapper.CreateAnimalMapper;

import java.util.List;
import java.util.stream.Collectors;

public class AnimalService implements Service {
    private static final AnimalService INSTANCE = new AnimalService();
    private final AnimalDao animalDao = AnimalDao.getInstance();
    private final AnimalMapper animalMapper = AnimalMapper.getInstance();
    private final CreateAnimalMapper createAnimalMapper = CreateAnimalMapper.getInstance();

    @Override
    public List<AnimalDto> findAll() {
        return animalDao.findAll().stream()
                .map(animalMapper::mapFrom)
                .collect(Collectors.toList());
    }

    @Override
    public AnimalDto findById(Integer id) {
        return animalMapper.mapFrom(animalDao.findById(id));
    }

    @Override
    public Animal save(CreateAnimalDto createAnimalDto) {
        Animal animalEntity = createAnimalMapper.mapFrom(createAnimalDto);
        animalDao.save(animalEntity);
        return animalEntity;
    }

    @Override
    public void update(CreateAnimalDto createAnimalDto, Integer id) {
        Animal animalEntity = createAnimalMapper.mapFrom(createAnimalDto);
        animalDao.update(animalEntity, id);
    }

    @Override
    public void delete(Integer id) {
        animalDao.delete(id);
    }

    public static AnimalService getInstance() {
        return INSTANCE;
    }

}
