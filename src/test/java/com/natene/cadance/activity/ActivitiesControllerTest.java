package com.natene.cadance.activity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.security.oauth2.client.autoconfigure.OAuth2ClientAutoConfiguration;
import org.springframework.boot.security.oauth2.client.autoconfigure.servlet.OAuth2ClientWebSecurityAutoConfiguration;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(
        value = ActivitiesController.class,
        excludeAutoConfiguration = {OAuth2ClientAutoConfiguration.class, OAuth2ClientWebSecurityAutoConfiguration.class}
)
class ActivitiesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ActivityService activityService;

    @Test
    void getActivities_returnsAllActivities() throws Exception {
        when(activityService.syncActivities(any())).thenReturn(List.of(
                ActivityEntity.builder().id(18455462292L).name("Afternoon Run").sportType("Run").build(),
                ActivityEntity.builder().id(18455462293L).name("Morning Ride").sportType("Ride").build()
        ));

        mockMvc.perform(get("/api/activities"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Afternoon Run"))
                .andExpect(jsonPath("$[0].sport_type").value("Run"))
                .andExpect(jsonPath("$[1].name").value("Morning Ride"))
                .andExpect(jsonPath("$[1].sport_type").value("Ride"));
    }
}
