package config;

import aspect.ExeTimeaspect2Java;
import chap007.Calculator;
import chap007.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


//자바 설정 config
@Configuration
@EnableAspectJAutoProxy
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
