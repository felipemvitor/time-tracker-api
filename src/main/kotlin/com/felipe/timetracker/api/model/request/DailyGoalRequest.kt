package com.felipe.timetracker.api.model.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


data class DailyGoalRequest(

    @NotBlank
    var name: String,

    @NotNull
    var yearGoal: Long,

    @NotNull
    var wowGoalMultiplier: Double
)