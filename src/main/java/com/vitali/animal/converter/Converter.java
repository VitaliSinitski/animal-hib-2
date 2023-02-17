package com.vitali.animal.converter;

import com.vitali.animal.dto.CreateAnimalDto;
import javax.servlet.http.HttpServletRequest;

import static com.vitali.animal.util.Constants.NAME;
import static com.vitali.animal.util.Constants.WEIGHT;

public class Converter {
    public static CreateAnimalDto convert(HttpServletRequest request) {
        return CreateAnimalDto.builder()
                .name(request.getParameter(NAME))
                .weight(Integer.valueOf(request.getParameter(WEIGHT)))
                .build();
    }
}
