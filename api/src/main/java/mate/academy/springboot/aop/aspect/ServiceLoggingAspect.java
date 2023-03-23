package mate.academy.springboot.aop.aspect;

import java.util.Arrays;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Log4j2
@Aspect
@Component
public class ServiceLoggingAspect {
    @Pointcut("execution(public * mate.academy.springboot.aop.service..*(..))")
    public void allServiceMethods() {
    }

    @Before("allServiceMethods()")
    public void beforeServiceMethodAdvice(JoinPoint joinPoint) {
        log.info(String.format(
                "Method %s.%s was called. Arguments: %s",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs())
        ));
    }
}
