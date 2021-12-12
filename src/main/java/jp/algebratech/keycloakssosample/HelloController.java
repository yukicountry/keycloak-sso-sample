package jp.algebratech.keycloakssosample;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class HelloController {
    private final WebClient webClient;

    public HelloController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/")
    public String top() {
        return "top";
    }

    @GetMapping("/home")
    public String index(@AuthenticationPrincipal OidcUser oAuth2User) {
        System.out.println(oAuth2User);
        System.out.println(this.webClient);
        return "home";
    }

    @GetMapping("/resource")
    public String resource() {
        return "resource";
    }
}
