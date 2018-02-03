package main;

import org.springframework.context.support.GenericXmlApplicationContext;
import spring.ChangePasswordService;
import spring.IdPasswordNotMatchingException;
import spring.MemberNotFoundException;

public class MainForCPS {
    public static void main(String[] args) {

        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext("classpath:appCtx.xml");

        ChangePasswordService cps =
                ctx.getBean("changePwdSvc", ChangePasswordService.class);

        try {
            cps.changePassword("madvirus@madvirus.net", "1234", "1111");
            System.out.println("암호를 변경 했습니다.");
        } catch (MemberNotFoundException e) {
            System.out.println("회원 데이터가 없습니다.");

        } catch (IdPasswordNotMatchingException e) {
            System.out.println("암호가 올바르지 않습니다.");
        }
        ctx.close();
    }
}
