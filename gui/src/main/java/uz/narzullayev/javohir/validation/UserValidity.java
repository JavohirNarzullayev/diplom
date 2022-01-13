package uz.narzullayev.javohir.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = UniqueUsernameValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface UserValidity {
    public String message() default "There is already user with this username!";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default{};
}