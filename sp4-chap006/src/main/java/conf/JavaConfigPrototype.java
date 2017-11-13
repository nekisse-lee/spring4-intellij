package conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import spring.Client;

@Configuration
public class JavaConfigPrototype {

    @Bean
    @Scope("prototype")
    public Client client(){
        Client client = new Client();
        client.setHost("javaconfig 프로토타입");
        return client;
    }


}
