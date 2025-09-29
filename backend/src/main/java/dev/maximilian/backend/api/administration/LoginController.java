package dev.maximilian.backend.api.administration;

import dev.maximilian.backend.data.entity.administration.Client;
import dev.maximilian.backend.data.service.administration.ClientDetailsService;
import dev.maximilian.backend.repository.administration.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final ClientRepository clientRepository;

    @GetMapping("register")
    public String register() {
        return "register";
    }

    @RequestMapping("/verification")
    public String verifyAccount(@RequestParam("verificationId") String verificationId) {
        Optional<Client> client = clientRepository.findByVerificationId(verificationId);

        if (client.isPresent()) {
            client.get().setVerified(true);
            clientRepository.save(client.get());
            return "redirect:/login";
        } else {
            return "redirect:/error";
        }
    }


    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<Client> client = clientRepository.findByUsername(authentication.getName());

        System.out.println(authentication.getName());


        if (client.isPresent()) {
            model.addAttribute("username", client.get().getUsername());
            model.addAttribute("apiKey", client.get().getApiKey());
        } else {
            model.addAttribute("error", "User not authenticated");
            return "login";
        }

        return "dashboard";
    }


}
