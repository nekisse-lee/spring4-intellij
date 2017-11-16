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

    @Pointcut("execution(public * chap007..*(..))")  // Aspect 를 적용할 위치
    // execution(수식어패턴 리턴타입패턴 클래스이름패턴? 메서드이름패턴(파라미터패턴)
    //  ex) execution(public void set*(..))     리턴타입 void , 메서드이름이 set으로 시작 파라미터가 0개 이상인 메서드 호출  '..' 0개이상 표현
    //  ex) execution(* chap007.*.*())   chap007패키지의 타입에 속한 파라미터가 없는 모든 메서드 호출
    //  ex) execution(* chap07..*.*(..))    chap07 및 하위 패키지에 있는 파라미터가 0개 이상인 메서드 호출.
    //                                       패키지부분에 '..'을 사용하여 해당패키지  또는 하위 패키지를 표현
    //  ex) execution(Long chap007.Calculator.factorial(..))     리턴 타입이 Long 인  Calculator 타입의 factorial 메서드 호출
    //  ex)  execution(* get*(*))    이름이 get으로 시작하고 1개의 파라미터를 갖는 메서드 호출
    //  ex)  execution(* get*(*, *))    이름이 get으로 시작하고 2개의 파라미터를 갖는 메서드 호출
    //  ex)  execution(* read*(Interger , ..)     메서드 이름이 read로 시작하고
    //                                            첫 번째 파라미터 타입이 Integer이며 1개 이상의 파라미터를 갖는 메서드 호출


    private void publicTarget() {
    }

    @Around("publicTarget()")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        try {
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long finish = System.nanoTime();
            Signature sig = joinPoint.getSignature();
            System.out.printf("%s.%s(%s) 실행 시간 : %d ns\n",
                    joinPoint.getTarget().getClass().getSimpleName(),
                    sig.getName(), Arrays.toString(joinPoint.getArgs()),
                    (finish - start));
        }
    }
}
