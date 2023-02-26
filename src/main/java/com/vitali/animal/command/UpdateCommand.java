package com.vitali.animal.command;

import com.vitali.animal.converter.Converter;
import com.vitali.animal.dto.AnimalDto;
import com.vitali.animal.exception.ValidationException;
import com.vitali.animal.service.AnimalService;
import com.vitali.animal.validator.CreateRequestValidator;
import com.vitali.animal.validator.ValidationResult;

import javax.servlet.http.HttpServletRequest;

import static com.vitali.animal.util.Constants.*;

public class UpdateCommand implements CrudCommand {
    private final CreateRequestValidator createRequestValidator = CreateRequestValidator.getInstance();
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
            try {
                ValidationResult validationResult = createRequestValidator.isValid(request);
                if (validationResult.hasErrors()) {
                    throw new ValidationException(validationResult.getErrors());
                }
                AnimalDto animalDto = Converter.convertUpdate(request, id);
                animalService.update(animalDto, id);
                request.setAttribute(ANIMAL_LIST, animalService.findAll());
                return LIST_JSP;
            } catch (ValidationException exception) {
                request.setAttribute(ERRORS, exception.getErrors());
                AnimalDto animalDto = animalService.findById(id);

                request.setAttribute(ANIMAL_DTO, animalDto);
                request.setAttribute(ID, id);
                return UPDATE_JSP;
            }
        }
    }
}
