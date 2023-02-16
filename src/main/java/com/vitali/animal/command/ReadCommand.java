package com.vitali.animal.command;

import com.vitali.animal.dto.AnimalDto;
import com.vitali.animal.service.AnimalService;
import com.vitali.animal.util.Constants;

import javax.servlet.http.HttpServletRequest;

import static com.vitali.animal.util.Constants.*;

public class ReadCommand implements CrudCommand{
    AnimalService animalService = AnimalService.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute(ANIMAL_LIST, animalService.findAll());
        return LIST_JSP;
    }
}
