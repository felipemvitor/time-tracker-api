package com.felipe.timetracker.api.model.request

import com.felipe.timetracker.domain.entity.Category
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

data class CategoryRequest(

    @NotBlank
    val name: String,

    @Positive
    val weeklyGoal: Long,

    @Positive
    val wowGoalMultiplier: Double
) {
    fun toCategory(): Category {
        return Category(
            null,
            name,
            weeklyGoal * 52,
            weeklyGoal,
            weeklyGoal / 7.0,
            wowGoalMultiplier
        )
    }
}