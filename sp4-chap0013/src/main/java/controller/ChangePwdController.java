package controller;


import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.AuthInfo;
import spring.ChangePasswordService;
import spring.IdPasswordNotMatchingException;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {

    private ChangePasswordService changePasswordService;

    public void setChangePasswordService(ChangePasswordService changePasswordService) {
        this.changePasswordService = changePasswordService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String form(@ModelAttribute("command") ChangePwdCommand pwdCmd, HttpSession session) {
        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
        if (authInfo == null) {
            return "redirect:/login";
        }
        return "edit/changePwdForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(@ModelAttribute("command") ChangePwdCommand pwdCmd, Errors errors, HttpSession session) {
        new ChangePwdCommandValidator().validate(pwdCmd, errors);
        if (errors.hasErrors()) {
            return "edit/changePwdForm";
        }
        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
        try {
            //컨트롤러는 로직 실행을 서비스에 위임한다.
            changePasswordService.changePassword(
                    authInfo.getEmail(),
                    pwdCmd.getCurrentPassword(),
                    pwdCmd.getNewPassword());
            return "edit/changedPwd";
        } catch (IdPasswordNotMatchingException e) {
            errors.rejectValue("currentPassword", "notMatching");
            return "edit/changePwdForm";
        }
    }
}
