package dev.maximilian.backend.api.administration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("register")
    public String register() {
        return "register"; // maps to src/main/resources/templates/register.html
    }

    @GetMapping("login")
    public String login() {
        return "login"; // maps to src/main/resources/templates/login.html
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // secured page
    }

}
