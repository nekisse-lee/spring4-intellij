package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @RequestMapping("/register/step1")
    public String handleStep1() {
        return "register/step1";
    }


    @RequestMapping(value = "/register/step2", method = RequestMethod.POST)
    public String handleStep2(
            @RequestParam(value = "agree", defaultValue = "false") Boolean agree) {
        if (!agree) {
            return "register/step1";
        }
        return "register/step2";
    }

    @RequestMapping(value = "/register/step2", method = RequestMethod.GET)
    public String handleStep2Get() {
        return "redirect:/register/step1";
    }
}
