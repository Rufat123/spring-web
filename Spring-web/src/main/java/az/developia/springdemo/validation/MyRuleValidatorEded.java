package az.developia.springdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyRuleValidatorEded implements ConstraintValidator<MustNumber, Integer>{

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		
		return value>100;
	}

}
