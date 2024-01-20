package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* demo.ShoppingCart.checkOut(..))")
    public void beforeLogger(JoinPoint jp){
        //System.out.println(jp.getSignature());
        String arg = jp.getArgs()[0].toString();
        System.out.println("Before Logger with argument: "+ arg);
    }
    @After("execution(* *.*.checkOut(..))")
    public void afterLogger(){
        System.out.println("After Logger");
    }

    @Pointcut("execution(* demo.ShoppingCart.quantity(..))")
    public void afterReturningPointcut(){};
    @AfterReturning(pointcut = "afterReturningPointcut()", returning = "retValue")
    public void afterReturning(String retValue){
        System.out.println("After returning: " + retValue);
    }
}
