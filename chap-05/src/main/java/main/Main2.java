package main;

import conf.JavaConfig2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class Main2 {
    public static void main(String[] args) {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(JavaConfig2.class);
        MemberRegisterService regSvc =
                ctx.getBean("memberRegSvc", MemberRegisterService.class);
        MemberInfoPrinter infoPrinter =
                ctx.getBean("infoPrint", MemberInfoPrinter.class);

        RegisterRequest regReq = new RegisterRequest();
        regReq.setEmail("nekisse@nekisse.net");
        regReq.setName("이선호");
        regReq.setPassword("1234");
        regReq.setConfirmPassword("1234");
        regSvc.regist(regReq);

        infoPrinter.printMemberInfo("nekisse@nekisse.net");
    }
}
