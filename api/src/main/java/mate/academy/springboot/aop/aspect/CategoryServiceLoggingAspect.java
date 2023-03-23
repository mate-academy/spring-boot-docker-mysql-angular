package mate.academy.springboot.aop.aspect;

import java.util.List;
import lombok.extern.log4j.Log4j2;
import mate.academy.springboot.aop.model.Category;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Log4j2
@Aspect
@Component
public class CategoryServiceLoggingAspect {
    @Pointcut("execution(* mate.academy.springboot.aop.service.CategoryService.findAll())")
    private void findAllCategoryServiceMethod() {
    }

    @Before("findAllCategoryServiceMethod()")
    public void beforeCategoryServiceFindAllMethodAdvice() {
        log.info("Method CategoryService.findAll was called");
    }

    @After("findAllCategoryServiceMethod()")
    public void afterCategoryServiceFindAllMethodAdvice() {
        log.info("Method CategoryService.findAll finished its execution.");
    }

    @AfterReturning(
            pointcut = "findAllCategoryServiceMethod()",
            returning = "result"
    )
    public void afterServiceMethodAdvice(List<Category> result) {
        log.info("The result size is " + result.size());
    }
}
