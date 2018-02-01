package main;

import chap007.Calculator;
import conf.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


  // 어노테이션 기반 실행 클래스
public class MainJavaAspect {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(JavaConfig.class);

        Calculator recCal = ctx.getBean("recCal", Calculator.class);

        long fiveFact = recCal.factorial(5);
        System.out.println("recCal.factorial(5) = " + fiveFact);


    }
}
