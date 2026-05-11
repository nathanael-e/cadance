package com.natene.cadance.activity;

import com.natene.cadance.strava.StravaService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
class ActivitiesController {

    private final StravaService stravaService;

    ActivitiesController(final StravaService stravaService) {
        this.stravaService = stravaService;
    }

    @GetMapping("/activities")
    List<SummaryActivity> getActivities(final Authentication auth) {
        return stravaService.fetchActivities(auth);
    }
}
