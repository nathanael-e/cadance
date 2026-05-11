package com.natene.cadance.activity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.natene.cadance.strava.StravaAthlete;
import com.natene.cadance.strava.StravaMap;

import java.util.List;

public record SummaryActivity(
        long id,
        String name,
        String sportType,
        String type,
        StravaAthlete athlete,
        float distance,
        int movingTime,
        int elapsedTime,
        float totalElevationGain,
        String startDate,
        String startDateLocal,
        String timezone,
        float averageSpeed,
        float maxSpeed,
        Float averageHeartrate,
        Float maxHeartrate,
        Float averageCadence,
        Float averageWatts,
        Integer maxWatts,
        Integer weightedAverageWatts,
        Float kilojoules,
        Boolean deviceWatts,
        boolean hasHeartrate,
        Float elevHigh,
        Float elevLow,
        Float sufferScore,
        int prCount,
        int achievementCount,
        int kudosCount,
        int commentCount,
        int athleteCount,
        int photoCount,
        String gearId,
        String deviceName,
        Integer workoutType,
        boolean trainer,
        boolean commute,
        boolean manual,
        @JsonProperty("private") boolean isPrivate,
        String visibility,
        boolean flagged,
        boolean hasKudoed,
        boolean heartrateOptOut,
        boolean fromAcceptedTag,
        long uploadId,
        String externalId,
        StravaMap map,
        List<Double> startLatlng,
        List<Double> endLatlng
) {
}
