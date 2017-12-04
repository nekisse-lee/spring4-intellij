package config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import spring.Client2;

@Configuration
public class JavaConfigPrototype {

    @Bean
    @Scope("prototype")
    public Client2 client2(){
        Client2 client2 = new Client2();
        client2.setHost("서버");
        return client2;
    }
}
