package com.felipe.timetracker.api.model.response

data class CategoryResponse(
    val id: Long?,
    val name: String,
    val yearGoal: Long,
    val weeklyGoal: Long,
    val dailyGoal: Double,
    val wowGoalMultiplier: Double
)