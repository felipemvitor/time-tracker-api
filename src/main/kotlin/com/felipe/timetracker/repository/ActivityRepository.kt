package com.felipe.timetracker.repository

import com.felipe.timetracker.entity.Activity
import org.springframework.data.jpa.repository.JpaRepository

interface ActivityRepository : JpaRepository<Activity, Long> {
}