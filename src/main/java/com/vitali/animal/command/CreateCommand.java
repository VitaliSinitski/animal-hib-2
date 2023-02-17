package com.vitali.animal.command;

import com.vitali.animal.converter.Converter;
import com.vitali.animal.dto.CreateAnimalDto;
import com.vitali.animal.exception.ValidationException;
import com.vitali.animal.service.AnimalService;

import javax.servlet.http.HttpServletRequest;

import static com.vitali.animal.util.Constants.*;

public class CreateCommand implements CrudCommand{
    private final AnimalService animalService = AnimalService.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        if (request.getMethod().equals(GET)) {
            return REGISTRATION_JSP;
        } else {
            CreateAnimalDto createAnimalDto = Converter.convert(request);
            try {
                animalService.save(createAnimalDto);
                request.setAttribute(ANIMAL_LIST, animalService.findAll());
                return LIST_JSP;
            } catch (ValidationException exception) {
                request.setAttribute(ERRORS, exception.getErrors());
                return REGISTRATION_JSP;
            }
        }
    }
}
