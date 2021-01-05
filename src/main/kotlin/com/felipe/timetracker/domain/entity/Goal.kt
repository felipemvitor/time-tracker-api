package com.felipe.timetracker.domain.entity

import com.felipe.timetracker.constants.DatabaseConstants
import com.felipe.timetracker.constants.DatabaseConstants.GOAL_TABLE
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity(name = GOAL_TABLE)
data class Goal(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @NotBlank
    @Column(name = DatabaseConstants.NAME)
    var name: String,

    @NotNull
    @Column(name = DatabaseConstants.YEARLY_GOAL)
    var yearGoal: Long,

    @NotNull
    @Column(name = DatabaseConstants.WEEKLY_GOAL)
    var weeklyGoal: Long,

    @NotNull
    @Column(name = DatabaseConstants.DAILY_GOAL)
    var dailyGoal: Long,

    @NotNull
    @Column(name = DatabaseConstants.WOW_GOAL_MULTIPLIER)
    var wowGoalMultiplier: Double

) : Serializable