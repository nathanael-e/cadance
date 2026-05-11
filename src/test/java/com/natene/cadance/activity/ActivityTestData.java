package com.natene.cadance.activity;

import com.natene.cadance.strava.StravaActivity;
import com.natene.cadance.strava.StravaAthlete;
import com.natene.cadance.strava.StravaMap;

class ActivityTestData {

    static StravaActivity afternoonRun() {
        return StravaActivity.builder()
                .id(18455462292L)
                .name("Afternoon Run")
                .sportType("Run")
                .type("Run")
                .athlete(new StravaAthlete(12345678L))
                .distance(16186.5f)
                .movingTime(5687)
                .elapsedTime(5687)
                .totalElevationGain(116.0f)
                .startDate("2026-05-10T12:55:09Z")
                .startDateLocal("2026-05-10T14:55:09Z")
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
                .uploadId(19560552435L)
                .externalId("garmin_ping_569613053335")
                .map(new StravaMap("a18455462292", ""))
                .isPrivate(true)
                .visibility("only_me")
                .athleteCount(1)
                .build();
    }
}
