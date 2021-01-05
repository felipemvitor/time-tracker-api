package com.felipe.timetracker.domain.entity

import com.felipe.timetracker.constants.DatabaseConstants
import com.felipe.timetracker.constants.DatabaseConstants.GOAL_TABLE
import java.io.Serializable
import javax.persistence.*

@Entity(name = GOAL_TABLE)
data class Goal(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(name = DatabaseConstants.NAME)
    var name: String,

    @Column(name = DatabaseConstants.YEARLY_GOAL)
    var yearGoal: Long,

    @Column(name = DatabaseConstants.WEEKLY_GOAL)
    var weeklyGoal: Long,

    @Column(name = DatabaseConstants.DAILY_GOAL)
    var dailyGoal: Long,

    @Column(name = DatabaseConstants.WOW_GOAL_MULTIPLIER)
    var wowGoalMultiplier: Double

) : Serializable