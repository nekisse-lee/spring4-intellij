package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class MainXmlJava {

    public static void main(String[] args) {

        ApplicationContext ctx =
                new GenericXmlApplicationContext("classpath:main-conf.xml");

        MemberRegisterService regSvc =
                ctx.getBean("memberRegSvc", MemberRegisterService.class);
        MemberInfoPrinter infoPrinter =
                ctx.getBean("infoPrinter", MemberInfoPrinter.class);

        RegisterRequest regReq = new RegisterRequest();
        regReq.setEmail("b@b.com");
        regReq.setName("bbbb");
        regReq.setPassword("bbbb");
        regReq.setConfirmPassword("bbbb");
        regSvc.regist(regReq);

        infoPrinter.printMemberInfo("b@b.com");
    }


}
