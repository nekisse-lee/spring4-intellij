package config;

import aspect.ExeTimeaspect2Java;
import chap007.Calculator;
import chap007.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


//자바빈 설정 config   = resource    ???.xml 빈 설정 대체
@Configuration
@EnableAspectJAutoProxy   //  인터페이스 상속 빈객체 말고 일반 객체 사용시  (proxyTargetClass = true) 추가
public class JavaConfig {

    @Bean
    public ExeTimeaspect2Java exeTimeAspect() {
        return new ExeTimeaspect2Java();
    }

    @Bean
    public Calculator recCal() {
        return new RecCalculator();
    }
}
