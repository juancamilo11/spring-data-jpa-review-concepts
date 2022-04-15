package dev.j3c.jpa.helpers.annotations.validators;

import dev.j3c.jpa.helpers.annotations.EmailDomain;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailDomainValidator implements ConstraintValidator<EmailDomain, String> {

    private String emailDomain;

    @Override
    public void initialize(EmailDomain constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.emailDomain = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String[] arrEmail = value.split("@");
        if(arrEmail.length != 2 ) return false;
        return arrEmail[1].equals(emailDomain);
    }
}
