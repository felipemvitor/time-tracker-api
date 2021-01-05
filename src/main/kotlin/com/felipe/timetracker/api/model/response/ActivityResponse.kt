package com.felipe.timetracker.api.model.response

data class ActivityResponse(
    val id: Long,
    val name: String,
    val dateStart: Long,
    val dateEnd: Long,
    val category: CategoryResponse
)