package com.daanam.app.backend.annotations;

import com.daanam.app.backend.models.validators.PanValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PanValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Pan {
  String message() default "Invalid PAN number";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
