package main;

import chap007.Calculator;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainXmlAspect {
    public static void main(String[] args) {

        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext("classpath:aopAspect.xml");

        Calculator impeCal = ctx.getBean("impeCal", Calculator.class);
        long ficeFact = impeCal.factorial(5);
        System.out.println("impeCal.factorial(5) = " + ficeFact);

    }
}
