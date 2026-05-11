package com.natene.cadance.activity;

import com.natene.cadance.TestDatabaseConfig;
import com.natene.cadance.strava.StravaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@Import(TestDatabaseConfig.class)
class ActivityServiceTest {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ActivityRepository repository;

    @MockitoBean
    private StravaService stravaService;

    @Test
    void syncActivities_persistsActivitiesToDatabase() {
        when(stravaService.fetchActivities(any())).thenReturn(List.of(
                ActivityTestData.afternoonRun()
        ));

        activityService.syncActivities(null);

        List<ActivityEntity> saved = repository.findAll();
        assertThat(saved).hasSize(1);

        ActivityEntity activity = saved.get(0);
        assertThat(activity.getId()).isEqualTo(18455462292L);
        assertThat(activity.getName()).isEqualTo("Afternoon Run");
        assertThat(activity.getSportType()).isEqualTo("Run");
        assertThat(activity.getAthleteId()).isEqualTo(12345678L);
        assertThat(activity.getDistance()).isEqualTo(16186.5f);
    }
}
