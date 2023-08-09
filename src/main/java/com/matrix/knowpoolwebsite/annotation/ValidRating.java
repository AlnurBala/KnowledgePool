package com.matrix.knowpoolwebsite.annotation;

import com.matrix.knowpoolwebsite.util.RatingValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RatingValidator.class)
public @interface ValidRating {
    String message() default "Invalid rating. Rating must be between 0 and 5 with increments of 0.5";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
