package az.developia.springdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyRuleValidator implements ConstraintValidator<java3, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		 if(value==null) {
			 return false;
		 }
		return value.startsWith("Telebe");
	}

}
