package az.developia.springdemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

//	@Before(value = "execution(* public * save*(..))")
//	public void doThis() {
//		System.out.println("Before save()");
//	}
}
