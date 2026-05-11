package com.natene.cadance.activity;

import org.springframework.data.jpa.repository.JpaRepository;

interface ActivityRepository extends JpaRepository<Activity, Long> {
}
