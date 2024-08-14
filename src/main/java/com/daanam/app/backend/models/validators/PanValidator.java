package com.daanam.app.backend.models.validators;

import com.daanam.app.backend.annotations.Pan;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PanValidator implements ConstraintValidator<Pan, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    Pattern pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");
    Matcher matcher = pattern.matcher(value);
    return matcher.matches();
  }
}
