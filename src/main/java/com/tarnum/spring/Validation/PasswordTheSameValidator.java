package com.tarnum.spring.Validation;

import com.tarnum.spring.Dto.RegistrationUserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordTheSameValidator implements ConstraintValidator<PasswordTheSame, RegistrationUserDTO> {
    @Override
    public void initialize(PasswordTheSame passwordTheSame) {

    }

    @Override
    public boolean isValid(RegistrationUserDTO registrationUserDTO, ConstraintValidatorContext constraintValidatorContext) {
        return registrationUserDTO.getPassword().equals(registrationUserDTO.getPassword1());
    }
}
