package com.vitali.animal.command;

import com.vitali.animal.dto.AnimalDto;
import com.vitali.animal.service.AnimalService;
import com.vitali.animal.util.Constants;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Objects;

import static com.vitali.animal.util.Constants.*;

public class ReadCommand implements CrudCommand{
    AnimalService animalService = AnimalService.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        Integer currentPage;
        Integer recordsPerPage;

        if (request.getParameter("currentPage") == null || request.getParameter("currentPage").isEmpty() || Objects.equals(request.getParameter("currentPage"), "0")) {
            currentPage = 1;
        } else {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }

        if (request.getParameter("recordsPerPage") == null || request.getParameter("recordsPerPage").isEmpty() || Objects.equals(request.getParameter("recordsPerPage"), "0")) {
            recordsPerPage = 10;
        } else {
            recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));
        }


        List<AnimalDto> animalList = animalService.findAllByPage(currentPage, recordsPerPage);
        request.setAttribute(ANIMAL_LIST, animalList);

        Integer rows = animalService.getNumberOfRows();
        int numberOfPages = rows / recordsPerPage;

        if (numberOfPages % recordsPerPage > 0) {
            numberOfPages++;
        }

        request.setAttribute("numberOfPages", numberOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);

        return LIST_JSP;
    }
}
