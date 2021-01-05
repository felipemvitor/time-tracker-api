package com.felipe.timetracker.domain.repository

import com.felipe.timetracker.domain.entity.Goal
import org.springframework.data.jpa.repository.JpaRepository

interface GoalRepository : JpaRepository<Goal, Long> {
}