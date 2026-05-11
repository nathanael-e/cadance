package com.natene.cadance.activity;

import com.natene.cadance.strava.StravaActivity;
import com.natene.cadance.strava.StravaService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ActivityService {

    private final StravaService stravaService;
    private final ActivityRepository repository;

    ActivityService(final StravaService stravaService, final ActivityRepository repository) {
        this.stravaService = stravaService;
        this.repository = repository;
    }

    public List<ActivityEntity> syncActivities(final Authentication auth) {
        List<StravaActivity> fetched = stravaService.fetchActivities(auth);
        List<ActivityEntity> activities = fetched.stream().map(this::toEntity).toList();
        return repository.saveAll(activities);
    }

    private ActivityEntity toEntity(final StravaActivity s) {
        List<Double> startLatlng = s.startLatlng();
        List<Double> endLatlng = s.endLatlng();
        return ActivityEntity.builder()
                .id(s.id())
                .athleteId(s.athlete().id())
                .name(s.name())
                .sportType(s.sportType())
                .type(s.type())
                .distance(s.distance())
                .movingTime(s.movingTime())
                .elapsedTime(s.elapsedTime())
                .totalElevationGain(s.totalElevationGain())
                .startDate(Instant.parse(s.startDate()))
                .startDateLocal(Instant.parse(s.startDateLocal()))
                .timezone(s.timezone())
                .averageSpeed(s.averageSpeed())
                .maxSpeed(s.maxSpeed())
                .averageHeartrate(s.averageHeartrate())
                .maxHeartrate(s.maxHeartrate())
                .averageCadence(s.averageCadence())
                .averageWatts(s.averageWatts())
                .maxWatts(s.maxWatts())
                .weightedAverageWatts(s.weightedAverageWatts())
                .kilojoules(s.kilojoules())
                .deviceWatts(s.deviceWatts())
                .hasHeartrate(s.hasHeartrate())
                .elevHigh(s.elevHigh())
                .elevLow(s.elevLow())
                .sufferScore(s.sufferScore())
                .prCount(s.prCount())
                .achievementCount(s.achievementCount())
                .kudosCount(s.kudosCount())
                .commentCount(s.commentCount())
                .athleteCount(s.athleteCount())
                .photoCount(s.photoCount())
                .gearId(s.gearId())
                .deviceName(s.deviceName())
                .workoutType(s.workoutType())
                .trainer(s.trainer())
                .commute(s.commute())
                .manual(s.manual())
                .isPrivate(s.isPrivate())
                .visibility(s.visibility())
                .flagged(s.flagged())
                .hasKudoed(s.hasKudoed())
                .heartrateOptOut(s.heartrateOptOut())
                .fromAcceptedTag(s.fromAcceptedTag())
                .uploadId(s.uploadId())
                .externalId(s.externalId())
                .mapId(s.map() != null ? s.map().id() : null)
                .summaryPolyline(s.map() != null ? s.map().summaryPolyline() : null)
                .startLat(startLatlng != null && startLatlng.size() == 2 ? startLatlng.get(0) : null)
                .startLng(startLatlng != null && startLatlng.size() == 2 ? startLatlng.get(1) : null)
                .endLat(endLatlng != null && endLatlng.size() == 2 ? endLatlng.get(0) : null)
                .endLng(endLatlng != null && endLatlng.size() == 2 ? endLatlng.get(1) : null)
                .build();
    }
}
