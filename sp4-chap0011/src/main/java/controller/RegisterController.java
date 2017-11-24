package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spring.AlreadyExistingMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import sun.jvm.hotspot.asm.Register;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {

    private MemberRegisterService memberRegisterService;

    public void setMemberRegisterService(
            MemberRegisterService memberRegisterService) {
        this.memberRegisterService = memberRegisterService;
    }

    @RequestMapping("/register/step1")
    public String handleStep1() {
        return "register/step1";
    }

    @RequestMapping(value = "/register/step2", method = RequestMethod.POST)
    public String handleStep2(
            @RequestParam(value = "agree", defaultValue = "false") Boolean agree,
            Model model) {
        if (!agree) {
            return "register/step1";
        }
        model.addAttribute("registerRequest", new RegisterRequest());
        return "register/step2";
    }


    @RequestMapping(value = "/register/step2", method = RequestMethod.GET)
    public String handleStep2Get() {
        return "redirect:/register/step1";
    }

    @RequestMapping(value = "/register/step3", method = RequestMethod.POST)
    public String handleStep3(RegisterRequest regReq) {
        try {
            memberRegisterService.regist(regReq);
            return "register/step3";
        } catch (AlreadyExistingMemberException ex) {
            return "register/step2";
        }
    }
//    public String handleStep3(HttpServletRequest request) {
//        String email = request.getParameter("eamail");
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
//        String confirmPassword = request.getParameter("confirmPassword");
//
//        RegisterRequest regReq = new RegisterRequest();
//        regReq.setEmail(email);
//        regReq.setName(name);
//    }


}