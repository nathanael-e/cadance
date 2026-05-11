package com.natene.cadance.security;

import com.natene.cadance.activity.SummaryActivity;
import com.natene.cadance.strava.StravaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.oauth2Login;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private StravaService stravaService;

    @Test
    void unauthenticatedRequest_redirectsToStravaLogin() throws Exception {
        mockMvc.perform(get("/api/activities"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/oauth2/authorization/strava"));
    }

    @Test
    void unauthenticatedDebugTokenRequest_redirectsToStravaLogin() throws Exception {
        mockMvc.perform(get("/api/debug/token"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/oauth2/authorization/strava"));
    }

    @Test
    void authenticatedRequest_returnsOk() throws Exception {
        when(stravaService.fetchActivities(any())).thenReturn(List.of(
                new SummaryActivity(1L, "Morning Run", "Run", 5000f, 1800, "2026-05-10T08:00:00Z")
        ));

        mockMvc.perform(get("/api/activities").with(oauth2Login()))
                .andExpect(status().isOk());
    }
}
