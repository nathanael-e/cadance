package com.natene.cadance;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/debug")
class DebugController {

    private final OAuth2AuthorizedClientService clientService;

    DebugController(final OAuth2AuthorizedClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/token")
    String getToken(final Authentication auth) {
        OAuth2AuthorizedClient client = clientService.loadAuthorizedClient("strava", auth.getName());
        return client.getAccessToken().getTokenValue();
    }
}
