package main;

import conf.JavaConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import spring.Client2;

public class Main2JavaConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(JavaConfig.class);


        Client2 client2 = ctx.getBean("client2", Client2.class);
        client2.send();
        ctx.close();
    }
}
