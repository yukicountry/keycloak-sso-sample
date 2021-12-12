package jp.algebratech.keycloakssosample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class KeycloakSsoSampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(KeycloakSsoSampleApplication.class, args);
    }


    @Bean
    OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager(
            ClientRegistrationRepository clientRegistrationRepository,
            OAuth2AuthorizedClientRepository auth2AuthorizedClientRepository) {
        return new DefaultOAuth2AuthorizedClientManager(clientRegistrationRepository, auth2AuthorizedClientRepository);
    }

    @Bean
    public WebClient webClient(OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager) {
        var oauth2Client = new ServletOAuth2AuthorizedClientExchangeFilterFunction(oAuth2AuthorizedClientManager);

        return WebClient
                .builder()
                .baseUrl("http://localhost:8082/resource")
                .apply(oauth2Client.oauth2Configuration())
                .build();
    }
}
