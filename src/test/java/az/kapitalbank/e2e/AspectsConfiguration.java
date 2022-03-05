package az.kapitalbank.e2e;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectsConfiguration {
	
	@After("execution(* az.kapitalbank.e2e.stepDef.*.*(..))")
    public void after(JoinPoint joinPoint) throws Throwable {
        System.out.println("after the Aspect");
        System.out.println("Invoking " + joinPoint.getSignature());
        System.out.println("******");
    }
	
	@Before("execution(* az.kapitalbank.e2e.stepDef.*.*(..))")
    public void before(JoinPoint joinPoint) throws Throwable {
        System.out.println("before the Aspect");
        System.out.println("Invoking " + joinPoint.getSignature());
        System.out.println("******");
    }
    
}