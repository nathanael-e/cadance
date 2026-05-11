package com.natene.cadance.activity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.postgresql.PostgreSQLContainer;

import java.time.Instant;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ActivityRepositoryTest {

    @TestConfiguration
    static class TestConfig {

        @Bean
        @ServiceConnection
        PostgreSQLContainer postgres() {
            return new PostgreSQLContainer("postgres:17");
        }
    }

    @Autowired
    private ActivityRepository repository;

    @Test
    void savedActivity_canBeRetrievedById() {
        ActivityEntity activity = ActivityEntity.builder()
                .id(18455462292L)
                .athleteId(12345678L)
                .name("Afternoon Run")
                .sportType("Run")
                .type("Run")
                .distance(16186.5f)
                .movingTime(5687)
                .elapsedTime(5687)
                .totalElevationGain(116.0f)
                .startDate(Instant.parse("2026-05-10T12:55:09Z"))
                .startDateLocal(Instant.parse("2026-05-10T14:55:09Z"))
                .timezone("(GMT+01:00) Europe/Stockholm")
                .averageSpeed(2.846f)
                .maxSpeed(6.38f)
                .averageHeartrate(164.5f)
                .maxHeartrate(180.0f)
                .averageCadence(80.2f)
                .averageWatts(356.2f)
                .maxWatts(628)
                .weightedAverageWatts(358)
                .kilojoules(2024.5f)
                .deviceWatts(true)
                .hasHeartrate(true)
                .elevHigh(46.8f)
                .elevLow(6.2f)
                .sufferScore(189.0f)
                .prCount(8)
                .achievementCount(19)
                .gearId("g30034069")
                .deviceName("Garmin Forerunner 265")
                .isPrivate(true)
                .visibility("only_me")
                .uploadId(19560552435L)
                .externalId("garmin_ping_569613053335")
                .mapId("a18455462292")
                .summaryPolyline("")
                .build();

        repository.save(activity);

        Optional<ActivityEntity> saved = repository.findById(18455462292L);
        assertThat(saved).isPresent();
        assertThat(saved.get().getName()).isEqualTo("Afternoon Run");
        assertThat(saved.get().getSportType()).isEqualTo("Run");
        assertThat(saved.get().getDistance()).isEqualTo(16186.5f);
        assertThat(saved.get().getStartDate()).isEqualTo(Instant.parse("2026-05-10T12:55:09Z"));
        assertThat(saved.get().getAthleteId()).isEqualTo(12345678L);
    }
}
