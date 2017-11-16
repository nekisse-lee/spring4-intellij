package main;

import chap007.Calculator;
import chap007.ImpeCalculator;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainXmlPojo {
    public static void main(String[] args) {

        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext("classpath:aopPojo.xml");

        Calculator impeCal = ctx.getBean("impeCal", Calculator.class);

/*
        # 1    인터페이스 상속 빈 말고   일반 클래스 이용시 !
        아래 코드는 실행 불가 익셉션 발생
         Bean named 'impeCal' must be of type [chap007.ImpeCalculator], but was actually of type [com.sun.proxy.$Proxy2]

         aopPojo.xml파일의 impeCal 은 Calculator 인터페이스 객체를 상속 받은 객체다
        이경우 인터페이스를 이용해서 프록시를 생성  때문에 아래 코드처럼 빈의 실제타입이 ImpeCalculator라고 하더라도"impeCal" 이름에 해당하는
        빈 객체의 타입은 CalCulator 인터페이스를 상속받은 프록시 타입이다
        ImpeCalculator impeCal = ctx.getBean("impeCal", ImpeCalculator.class);
        */
        long fiveFact1 = impeCal.factorial(5);
        System.out.println("impeCal.factorial(5) = " + fiveFact1);

        Calculator recCal = ctx.getBean("recCal", Calculator.class);
        long fiveFace2 = recCal.factorial(5);
        System.out.println("recCal.factorial(5) = " + fiveFace2);

    }
}
