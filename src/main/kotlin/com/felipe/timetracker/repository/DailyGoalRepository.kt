package com.felipe.timetracker.repository

import com.felipe.timetracker.entity.DailyGoal
import org.springframework.data.jpa.repository.JpaRepository

interface DailyGoalRepository : JpaRepository<DailyGoal, Long> {
}