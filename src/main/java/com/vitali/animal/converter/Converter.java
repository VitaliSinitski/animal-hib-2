package com.vitali.animal.converter;

import com.vitali.animal.dto.AnimalDto;

import javax.servlet.http.HttpServletRequest;

import static com.vitali.animal.util.Constants.NAME;
import static com.vitali.animal.util.Constants.WEIGHT;

public class Converter {
    public static AnimalDto convertCreate(HttpServletRequest request) {
        return AnimalDto.builder()

                .name(request.getParameter(NAME))
                .weight(Integer.valueOf(request.getParameter(WEIGHT)))
                .build();
    }

    public static AnimalDto convertUpdate(HttpServletRequest request, Integer id) {
        return AnimalDto.builder()
                .id(id)
                .name(request.getParameter(NAME))
                .weight(Integer.valueOf(request.getParameter(WEIGHT)))
                .build();
    }
}
