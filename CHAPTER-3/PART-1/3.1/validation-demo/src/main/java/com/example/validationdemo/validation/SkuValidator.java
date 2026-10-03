package com.example.validationdemo.validation;

import com.example.validationdemo.annotation.Sku;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class SkuValidator implements ConstraintValidator<Sku, String> {

    private static final Pattern SKU_PATTERN = Pattern.compile("^[A-Z0-9]{8}$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || SKU_PATTERN.matcher(value).matches();
    }
}