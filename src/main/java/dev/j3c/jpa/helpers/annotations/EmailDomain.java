package dev.j3c.jpa.helpers.annotations;

import dev.j3c.jpa.helpers.annotations.validators.EmailDomainValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailDomainValidator.class)
public @interface EmailDomain {

    String value() default "udea.edu.co";

    String message() default "Email domain must be udea.edu.co";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
