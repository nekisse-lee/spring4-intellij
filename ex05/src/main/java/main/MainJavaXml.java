package main;

import config.JavaMainConf;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class MainJavaXml {

    public static void main(String[] args) {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(JavaMainConf.class);
        MemberRegisterService regSvc =
                ctx.getBean("memberRegSvc", MemberRegisterService.class);
        MemberInfoPrinter infoPrinter =
                ctx.getBean("infoPrinter", MemberInfoPrinter.class);

        RegisterRequest regReq = new RegisterRequest();
        regReq.setEmail("a@a.com");
        regReq.setName("aaaa");
        regReq.setPassword("aaaa");
        regReq.setConfirmPassword("aaaa");
        regSvc.regist(regReq);

        infoPrinter.printMemberInfo("a@a.com");
    }

}
