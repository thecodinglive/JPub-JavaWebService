package info.thecodinglive.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * Created by jins on 2017-01-30.
 */
//@Component
//@Aspect
@Order(Ordered.LOWEST_PRECEDENCE) //int로 우선순위를 정할 수 있음
/*
* ex) @Order(1)
*     @Order(2)
* */
public class Aspect1 {
    @Around("execution(* info.thecodinglive.controller.*.*(..))")
    public Object doBasicProfiling(ProceedingJoinPoint joinPoint)throws Throwable{
        Long t1 = System.currentTimeMillis();
        Object returnValue = joinPoint.proceed();
        Long t2 = System.currentTimeMillis();
        Long executionTime = t2 - t1;

        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("============================================================");
        System.out.println(className + "." + methodName + "() took" + executionTime + "ms");
        System.out.println("============================================================");

        return returnValue;
    }

    @Before("execution(* info.thecodinglive.service.*.*(..))")
    public void logArguments(JoinPoint joinPoint){
        Object[] arguments = joinPoint.getArgs();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();

        System.out.println("--------------" + className + "." + methodName + "()------");

        for(int i=0; i<arguments.length; i++){
            System.out.println("전달받은 파라메터:: " + arguments[i]);
        }
    }

  @AfterReturning(pointcut = "execution(* info.thecodinglive.service.*.*(..))",
            returning = "returnValue")
    public void logReturnValue(JoinPoint joinPoint, Object returnValue){
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("-----" + className + "." + methodName + "()-------");
        System.out.println("returnValue= " + returnValue.toString() );
    }

    @AfterThrowing(pointcut = "execution(* info.thecodinglive.controller.*.*(..))",
        throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception){
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("-----------" + className + "." + methodName + "()-------");
        System.out.println("exception message" + exception.getMessage());
    }

    @After("execution(* info.thecodinglive.controller.*.*(..))")
    public void cleanUp(JoinPoint joinPoint){
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("-----------cleanup:: " + className + "." + methodName + "()-------");
    }

    @DeclareParents(value = "info.thecodinglive.controller.*+", defaultImpl = LoggingConsole.class)
    public static Logging mixin;

    @Before("execution(* info.thecodinglive.controller.*.*(..)) && this(logging)")
    public void logControllerMethod(Logging logging){
        logging.log("display method execution");
    }

}
