package dev.maximilian.backend.api.administration;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // maps to src/main/resources/templates/login.html
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // secured page
    }

}
