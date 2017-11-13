package main;

import conf.JavaConfigPrototype;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import spring.Client;

public class MainPrototypeJavaConfig {
    public static void main(String[] args) {
        AbstractApplicationContext ctx =
                new AnnotationConfigApplicationContext(JavaConfigPrototype.class);
        Client client1 = ctx.getBean("client", Client.class);
        Client client2 = ctx.getBean("client", Client.class);

        System.out.println("자바 config prototype 설정한 client1 과 client2 는 같은가");

        System.out.println(client1==client2);
    }
}
