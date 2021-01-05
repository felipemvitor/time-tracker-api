package com.felipe.timetracker.api.model.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


data class DailyGoalRequest(

    @NotBlank
    val name: String,

    @NotNull
    val yearGoal: Long,

    @NotNull
    val wowGoalMultiplier: Double
)