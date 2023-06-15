package com.it.validation;

import java.time.LocalDate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BeforeDateValidator implements ConstraintValidator<DateOfBirthValid, LocalDate> {


	private LocalDate targetDate;

	@Override
	public void initialize(DateOfBirthValid constraintAnnotation) {
		this.targetDate = LocalDate.parse(constraintAnnotation.value());
	}
	
	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		if (value == null) {
            return true;
        }
        return value.isBefore(targetDate);
    
	}

}
