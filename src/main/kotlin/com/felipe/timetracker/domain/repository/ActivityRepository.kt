package com.felipe.timetracker.domain.repository

import com.felipe.timetracker.domain.entity.Activity
import org.springframework.data.jpa.repository.JpaRepository

interface ActivityRepository : JpaRepository<Activity, Long> {
}