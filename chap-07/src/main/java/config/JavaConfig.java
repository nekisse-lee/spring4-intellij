package config;

import aspect.ExeTimeAspect2;
import chap07.Calculator;
import chap07.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class JavaConfig {

    @Bean
    public ExeTimeAspect2 exeTimeAspect(){
        return new ExeTimeAspect2();
    }

    @Bean
    public Calculator recCal(){
        return new RecCalculator();
    }

}
