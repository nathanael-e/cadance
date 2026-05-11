package com.natene.cadance.strava;

import com.natene.cadance.activity.SummaryActivity;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StravaService {

    private final OAuth2AuthorizedClientService clientService;
    private final RestClient restClient;

    StravaService(final OAuth2AuthorizedClientService clientService, final RestClient stravaRestClient) {
        this.clientService = clientService;
        this.restClient = stravaRestClient;
    }

    public List<SummaryActivity> fetchActivities(final Authentication auth) {
        String token = resolveToken(auth);
        long after = Instant.now().minus(365, ChronoUnit.DAYS).getEpochSecond();

        List<SummaryActivity> all = new ArrayList<>();
        int page = 1;
        while (true) {
            List<SummaryActivity> batch = fetchPage(token, after, page);
            if (batch.isEmpty()) {
                break;
            }
            all.addAll(batch);
            page++;
        }
        return all;
    }

    private List<SummaryActivity> fetchPage(final String token, final long after, final int page) {
        List<SummaryActivity> body = restClient.get()
                .uri("/athlete/activities?after={after}&per_page=200&page={page}", after, page)
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .body(new ParameterizedTypeReference<>() { });
        return Objects.requireNonNullElse(body, List.of());
    }

    private String resolveToken(final Authentication auth) {
        OAuth2AuthorizedClient client = clientService.loadAuthorizedClient("strava", auth.getName());
        return client.getAccessToken().getTokenValue();
    }
}
