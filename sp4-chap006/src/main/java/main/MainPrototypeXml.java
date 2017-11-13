package main;

import org.springframework.context.support.GenericXmlApplicationContext;
import spring.Client;

public class MainPrototypeXml {

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext("classpath:springconfPrototype.xml");
        Client client1 = ctx.getBean("client", Client.class);
        Client client2 = ctx.getBean("client", Client.class);

        Client client3 = ctx.getBean("client1", Client.class);
        Client client4 = ctx.getBean("client1", Client.class);
        System.out.println();
        System.out.println( "prototype설정한 cluent1과 client2는 같은가");
        System.out.println(client1==client2);


        System.out.println();
        System.out.println( "일반 cluent3과 client4는 같은가");
        System.out.println(client3==client4);




    }

}
