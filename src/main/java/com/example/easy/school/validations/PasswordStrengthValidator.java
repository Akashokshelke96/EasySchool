package com.example.easy.school.validations;

import com.example.easy.school.annotations.PasswordValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordValidator,String> {

    List<String> weakPasswords;

    @Override
    public void initialize(PasswordValidator passwordValidators) {
        weakPasswords = Arrays.asList("12345", "password", "qwerty");
    }

    @Override
    public boolean isValid(String passwordField, ConstraintValidatorContext ctx) {
        return passwordField != null && (!weakPasswords.contains(passwordField));
    }
}
