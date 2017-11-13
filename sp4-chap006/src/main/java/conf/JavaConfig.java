package conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.Client2;

@Configuration
public class JavaConfig {

    @Bean(initMethod = "connect", destroyMethod = "close")
    public Client2 client2(){
        Client2 client2 = new Client2();
        client2.setHost("서버2");
        //client2.connect(); @Bean어노테이션에 initMethod 를 사용하지 않고 적용메서드에 직접 초기화메서드를 실행해도 된다.
        return client2;
    }
}
