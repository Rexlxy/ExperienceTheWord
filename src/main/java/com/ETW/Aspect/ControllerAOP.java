package com.ETW.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAOP {

    @Pointcut("execution(* com.ETW.Controller..*(..))")
    public void controllerAsp(){	}

    @Pointcut("execution(* com.ETW.Service..*(..))")
    public void serviceAsp(){	}

    public void handleException() {

    }

    @Before("controllerAsp()")
    public void beforeController(JoinPoint joinPoint) {
        System.out.println("Controller Method called: " + joinPoint.getSignature().getName());
        for (Object arg : joinPoint.getArgs()) {
            System.out.println("- Arg: " + arg.toString());
        }
    }

    @Before("serviceAsp()")
    public void beforeService(JoinPoint joinPoint) {
        System.out.println("Service Method called: " + joinPoint.getSignature().getName());
        for (Object arg : joinPoint.getArgs()) {
            System.out.println("- Arg: " + arg.toString());
        }
    }

    @AfterReturning("serviceAsp()")
    public void afterService(JoinPoint joinPoint) {
        System.out.println("After Service Method : " + joinPoint.getSignature().getName());
        System.out.println(joinPoint);
    }
}
