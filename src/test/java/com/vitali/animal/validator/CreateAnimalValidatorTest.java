package com.vitali.animal.validator;

import com.vitali.animal.dto.CreateAnimalDto;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class CreateAnimalValidatorTest {
    private final CreateAnimalValidator validator = CreateAnimalValidator.getInstance();

    @Test
    void shouldPassValidation() {

        CreateAnimalDto dto = CreateAnimalDto.builder()
                .name("Mona")
                .weight(8)
                .build();

        ValidationResult actualResult = validator.isValid(dto);

        assertFalse(actualResult.hasErrors());
    }

    @Test
    void emptyNameField() {

        CreateAnimalDto dto = CreateAnimalDto.builder()
                .name("")
                .weight(8)
                .build();

        ValidationResult actualResult = validator.isValid(dto);

        assertThat(actualResult.getErrors()).hasSize(1);
        assertThat(actualResult.getErrors().get(0).getCode()).isEqualTo("invalid.input.name.empty");
    }


    @Test
    void nullWeightField() {
        CreateAnimalDto dto = CreateAnimalDto.builder()
                .name("Jack")
                .weight(0)
                .build();

        ValidationResult actualResult = validator.isValid(dto);

        assertThat(actualResult.getErrors()).hasSize(1);
        assertThat(actualResult.getErrors().get(0).getCode()).isEqualTo("invalid.input.weight.null");
    }

    @Test
    void lengthNameField() {
        CreateAnimalDto dto = CreateAnimalDto.builder()
                .name("J")
                .weight(3)
                .build();

        ValidationResult actualResult = validator.isValid(dto);

        assertThat(actualResult.getErrors()).hasSize(1);
        assertThat(actualResult.getErrors().get(0).getCode()).isEqualTo("invalid.input.name.length");
    }

    @Test
    void emptyNameNullWeightField() {
        CreateAnimalDto dto = CreateAnimalDto.builder()
                .name("J")
                .weight(0)
                .build();

        ValidationResult actualResult = validator.isValid(dto);

        assertThat(actualResult.getErrors()).hasSize(2);
        List<String> errorCodes = actualResult.getErrors().stream()
                .map(Error::getCode).toList();
        assertThat(errorCodes).contains("invalid.input.name.length", "invalid.input.weight.null");
    }

    @Test
    void lengthNameNullWeightField() {
        CreateAnimalDto dto = CreateAnimalDto.builder()
                .name("")
                .weight(0)
                .build();

        ValidationResult actualResult = validator.isValid(dto);

        assertThat(actualResult.getErrors()).hasSize(2);
        List<String> errorCodes = actualResult.getErrors().stream()
                .map(Error::getCode).toList();
        assertThat(errorCodes).contains("invalid.input.name.empty", "invalid.input.weight.null");
    }

}