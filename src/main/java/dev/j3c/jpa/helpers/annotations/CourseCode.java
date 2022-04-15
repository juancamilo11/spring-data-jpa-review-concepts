package dev.j3c.jpa.helpers.annotations;

import dev.j3c.jpa.helpers.annotations.validators.CourseCodeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
@Constraint(validatedBy = CourseCodeValidator.class)
public @interface CourseCode {

    String value() default "UdeA";

    String message() default "Course code must start with 'UdeA'";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] Payload() default {};

}
