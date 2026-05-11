package com.natene.cadance.activity;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
class ActivitiesController {

    private final ActivityService activityService;

    ActivitiesController(final ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/activities")
    List<ActivityEntity> getActivities(final Authentication auth) {
        return activityService.syncActivities(auth);
    }
}
