package com.it.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD,ElementType.PARAMETER ,ElementType.ANNOTATION_TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = BeforeDateValidator.class)
public @interface DateOfBirthValid{
    String value();
//    error message
    String message() default "Date should be before the specified date {value}";
//    group of constraints
    Class<?>[] groups() default {};
//    additional info about annotations
    Class<? extends Payload>[] payload() default {};
}

