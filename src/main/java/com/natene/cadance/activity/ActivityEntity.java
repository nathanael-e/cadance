package com.natene.cadance.activity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class ActivityEntity {

    @Id
    private long id;
    private long athleteId;
    private String name;
    private String sportType;
    private String type;
    private float distance;
    private int movingTime;
    private int elapsedTime;
    private float totalElevationGain;
    private Instant startDate;
    private Instant startDateLocal;
    private String timezone;
    private float averageSpeed;
    private float maxSpeed;
    private Float averageHeartrate;
    private Float maxHeartrate;
    private Float averageCadence;
    private Float averageWatts;
    private Integer maxWatts;
    private Integer weightedAverageWatts;
    private Float kilojoules;
    private Boolean deviceWatts;
    private boolean hasHeartrate;
    private Float elevHigh;
    private Float elevLow;
    private Float sufferScore;
    private int prCount;
    private int achievementCount;
    private int kudosCount;
    private int commentCount;
    private int athleteCount;
    private int photoCount;
    private String gearId;
    private String deviceName;
    private Integer workoutType;
    private boolean trainer;
    private boolean commute;
    private boolean manual;
    private boolean isPrivate;
    private String visibility;
    private boolean flagged;
    private boolean hasKudoed;
    private boolean heartrateOptOut;
    private boolean fromAcceptedTag;
    private long uploadId;
    private String externalId;
    private String mapId;
    @Column(columnDefinition = "TEXT")
    private String summaryPolyline;
    private Double startLat;
    private Double startLng;
    private Double endLat;
    private Double endLng;
}
