package com.drone.common.helper;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnumValidatorValues implements ConstraintValidator< EnumValidator , String > {
  private Set < String > allowedValues;

  @Override public void initialize(EnumValidator targetEnum) {
    Class < ? extends Enum > enumSelected = targetEnum.targetClassType();
    allowedValues = (Set< String >) EnumSet.allOf(enumSelected).stream()
                                           .map(e -> ((Enum < ? extends Enum < ? >>) e).name())
        .collect(Collectors.toSet());

  }

  @Override public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
    if(allowedValues.contains(value.toUpperCase()))
      return true;
    else
      return false;
  }
}
