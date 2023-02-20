package com.vitali.animal.validator;

import com.vitali.animal.dto.CreateAnimalDto;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CreateAnimalValidator implements Validator<CreateAnimalDto> {

    private static final CreateAnimalValidator INSTANCE = new CreateAnimalValidator();

    public static CreateAnimalValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public ValidationResult isValid(CreateAnimalDto object) {
        ValidationResult validationResult = new ValidationResult();
        if (object.getName().isEmpty()) {
            validationResult.add(Error.of("invalid.input.name.empty", "Введите имя! Поле должно быть заполнено"));
        }
//        if (object.getWeight().isEmpty()) {
//            validationResult.add(Error.of("invalid.input.weight.null", "Введите вес! Поле должно быть заполнено"));
//        }
        if (object.getWeight() < 1) {
            validationResult.add(Error.of("invalid.input.weight.null", "Введите правильный вес! Вес должен быть больше 0"));
        }
        if (object.getName().length() == 1){
            validationResult.add(Error.of("invalid.input.name.length", "Длина имени должна быть более одного символа"));
        }
//        boolean letter = !object.getSurname().matches("[A-Za-zА-Яа-я]") || !object.getName().matches("[A-Za-zА-Яа-я]");
//        boolean empty = !object.getName().isEmpty() && !object.getSurname().isEmpty();
//        if (letter && empty) {
//            validationResult.add(Error.of("invalid.input", "Можно использовать только буквы"));
//        }

        return validationResult;
    }

}
