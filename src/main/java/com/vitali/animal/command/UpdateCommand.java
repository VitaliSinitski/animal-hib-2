package com.vitali.animal.command;

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
        Integer id = Integer.valueOf(request.getParameter(ID));

        if (request.getMethod().equals(GET)) {
            AnimalDto animalDto = animalService.findById(id);
            request.setAttribute(ANIMAL_DTO, animalDto);
            request.setAttribute(ID, id);
            return UPDATE_JSP;
        } else {
            CreateAnimalDto createAnimalDto = CreateAnimalDto.builder()
                    .name(request.getParameter(NAME))
                    .weight(Integer.valueOf(request.getParameter(WEIGHT)))
                    .build();
            animalService.update(createAnimalDto, id);
            request.setAttribute(ANIMAL_LIST, animalService.findAll());
            return LIST_JSP;
        }
    }
}
