package com.vitali.animal.command;

import com.vitali.animal.service.AnimalService;
import com.vitali.animal.util.Constants;

import javax.servlet.http.HttpServletRequest;

import static com.vitali.animal.util.Constants.*;

public class DeleteCommand implements CrudCommand{
    private final AnimalService animalService = AnimalService.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        Integer id = Integer.valueOf(request.getParameter(ID));
        animalService.delete(id);
        request.setAttribute(ANIMAL_LIST, animalService.findAll());
        return LIST_JSP;
    }
}
