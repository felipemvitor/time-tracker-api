package com.felipe.timetracker.api.model.response

data class DailyGoalResponse(
    val id: Long?,
    val name: String,
    val yearGoal: Long,
    val weeklyGoal: Long,
    val dailyGoal: Long,
    val wowGoalMultiplier: Double
)