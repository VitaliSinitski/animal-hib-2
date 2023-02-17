package com.vitali.animal.command;

import com.vitali.animal.converter.Converter;
import com.vitali.animal.dto.AnimalDto;
import com.vitali.animal.dto.CreateAnimalDto;
import com.vitali.animal.service.AnimalService;
import com.vitali.animal.util.Constants;

import javax.servlet.http.HttpServletRequest;

import static com.vitali.animal.util.Constants.*;

public class UpdateCommand implements CrudCommand {

    AnimalService animalService = AnimalService.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter(ID));

        if (request.getMethod().equals(GET)) {
            AnimalDto animalDto = animalService.findById(id);
            request.setAttribute(ANIMAL_DTO, animalDto);
            request.setAttribute(ID, id);
            return UPDATE_JSP;
        } else {
            CreateAnimalDto createAnimalDto = Converter.convert(request);
            animalService.update(createAnimalDto, id);
            request.setAttribute(ANIMAL_LIST, animalService.findAll());
            return LIST_JSP;
        }
    }
}
