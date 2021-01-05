package com.felipe.timetracker.api.model.response

data class GoalResponse(
    val id: Long?,
    val name: String,
    val yearlyGoal: Long,
    val weeklyGoal: Long,
    val dailyGoal: Long,
    val wowGoalMultiplier: Double
)