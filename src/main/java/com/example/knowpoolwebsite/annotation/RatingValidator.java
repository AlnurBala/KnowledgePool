package com.example.knowpoolwebsite.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;

public class RatingValidator implements ConstraintValidator<ValidRating, BigDecimal> {
    private static final BigDecimal MIN_RATING = BigDecimal.ZERO;
    private static final BigDecimal MAX_RATING = BigDecimal.valueOf(5);
    private static final BigDecimal STEP_SIZE = BigDecimal.valueOf(0.5);

    @Override
    public void initialize(ValidRating constraintAnnotation) {
        // No initialization needed.
    }

    @Override
    public boolean isValid(BigDecimal rating, ConstraintValidatorContext context) {
        if (rating == null) {
            return true; // Null values are considered valid
        }
        return rating.compareTo(MIN_RATING) >= 0 &&
                rating.compareTo(MAX_RATING) <= 0 &&
                rating.remainder(STEP_SIZE).compareTo(BigDecimal.ZERO) == 0;
    }
}