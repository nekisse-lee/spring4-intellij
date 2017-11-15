package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;


// @Aspect 어노테이션을 이용하는 방법   aopAspect.xml
@Aspect
public class ExeTimeaspect2Java {

    @Pointcut("execution(public * chap007..*(..))")
    private void publicTarget(){
    }

    @Around("publicTarget()")
    public Object measure(ProceedingJoinPoint joinPoint) throws  Throwable{
        long start = System.nanoTime();
        try{
            Object result = joinPoint.proceed();
            return result;
        }finally {
            long finish = System.nanoTime();
            Signature sig = joinPoint.getSignature();
            System.out.printf("%s.%s(%s) 실행 시간 : %d ns\n",
                    joinPoint.getTarget().getClass().getSimpleName(),
                    sig.getName(), Arrays.toString(joinPoint.getArgs()),
                    (finish - start));
        }
    }
}
