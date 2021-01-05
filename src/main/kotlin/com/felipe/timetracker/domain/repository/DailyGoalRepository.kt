package com.felipe.timetracker.domain.repository

import com.felipe.timetracker.domain.entity.DailyGoal
import org.springframework.data.jpa.repository.JpaRepository

interface DailyGoalRepository : JpaRepository<DailyGoal, Long> {
}