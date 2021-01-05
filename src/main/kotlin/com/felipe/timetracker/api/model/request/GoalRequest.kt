package com.felipe.timetracker.api.model.request

import com.felipe.timetracker.domain.entity.Goal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class GoalRequest(

    @NotBlank
    val name: String,

    @NotNull
    val yearGoal: Long,

    @NotNull
    val wowGoalMultiplier: Double
) {
    fun toGoal(): Goal {
        return Goal(
            null,
            name,
            yearGoal,
            yearGoal / 52,
            yearGoal / 52 / 7,
            wowGoalMultiplier
        )
    }
}