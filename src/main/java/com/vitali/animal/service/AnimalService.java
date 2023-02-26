package com.vitali.animal.service;

import com.vitali.animal.dao.AnimalDao;
import com.vitali.animal.dto.AnimalDto;
import com.vitali.animal.entity.Animal;
import com.vitali.animal.exception.ValidationException;
import com.vitali.animal.mapper.AnimalMapper;
import com.vitali.animal.validator.CreateAnimalValidator;
import com.vitali.animal.validator.ValidationResult;

import java.util.List;
import java.util.stream.Collectors;

public class AnimalService implements Service {
    private static final AnimalService INSTANCE = new AnimalService();
    private final AnimalDao animalDao = AnimalDao.getInstance();
    private final AnimalMapper animalMapper = AnimalMapper.getInstance();
    private final CreateAnimalValidator createAnimalValidator = CreateAnimalValidator.getInstance();

    @Override
    public List<AnimalDto> findAll() {
        return animalDao.findAll().stream()
                .map(animalMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public List<AnimalDto> findAllByPage(Integer currentPage, Integer recordsPerPage) {
        return animalDao.findAllByPage(currentPage, recordsPerPage)
                .stream()
                .map(animalMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public Integer getNumberOfRows() {
        return animalDao.getNumberOfRows();
    }

    @Override
    public AnimalDto findById(Integer id) {
        return animalMapper.mapToDto(animalDao.findById(id));
    }

    @Override
    public void delete(Integer id) {
        animalDao.delete(id);
    }

    @Override
    public void update(AnimalDto animalDto, Integer id) {
        Animal animalEntity = animalMapper.mapToEntity(animalDto);
        animalDao.update(animalEntity, id);
    }

    @Override
    public AnimalDto save(AnimalDto animalDto) {
        ValidationResult validationResult = createAnimalValidator.isValid(animalDto);
        if (validationResult.hasErrors()) {
            throw new ValidationException(validationResult.getErrors());
        }

        Animal animal = animalMapper.mapToEntity(animalDto);
        Animal animalEntity = animalDao.save(animal);
//        return animalEntity;
        return animalMapper.mapToDto(animalEntity);
    }
    public static AnimalService getInstance() {
        return INSTANCE;
    }

}
