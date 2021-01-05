package com.felipe.timetracker.domain.entity

import com.felipe.timetracker.api.model.response.ActivityResponse
import com.felipe.timetracker.api.model.response.GoalResponse
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
    var yearlyGoal: Long,

    @NotNull
    @Column(name = DatabaseConstants.WEEKLY_GOAL)
    var weeklyGoal: Long,

    @NotNull
    @Column(name = DatabaseConstants.DAILY_GOAL)
    var dailyGoal: Long,

    @NotNull
    @Column(name = DatabaseConstants.WOW_GOAL_MULTIPLIER)
    var wowGoalMultiplier: Double

) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Goal

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    fun toGoalResponse(): GoalResponse {
        return GoalResponse(id!!, name!!, yearlyGoal!!, weeklyGoal!!, dailyGoal!!, wowGoalMultiplier!!)
    }
}