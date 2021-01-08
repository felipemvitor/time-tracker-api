package com.felipe.timetracker.domain.repository

import com.felipe.timetracker.domain.entity.Activity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ActivityRepository : JpaRepository<Activity, Long> {

    fun findActivitiesByCategoryId(id: Long): List<Activity>
}