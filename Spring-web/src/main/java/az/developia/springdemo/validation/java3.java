package az.developia.springdemo.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = MyRuleValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface java3 {
	String message() default "Adin qarsisinda Telebe yazilmalidir!";

	Class<? extends Payload>[] payload() default {};

	Class<?>[] groups() default {};
}