package com.vitali.animal.exception;

import lombok.Getter;
import com.vitali.animal.validator.Error;

import java.util.List;

public class ValidationException extends RuntimeException {

    @Getter
    private final List<Error> errors;

    public ValidationException(List<Error> errors) {
        this.errors = errors;
    }

}
