package main;

import com.sun.xml.internal.xsom.parser.AnnotationContext;
import conf.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.Client2;

public class Main2 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(JavaConfig.class);
        Client2 client2 = ctx.getBean("client2", Client2.class);
        client2.send();
        ctx.close();


    }
}
