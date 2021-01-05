package com.felipe.timetracker.api.model.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

data class CategoryRequest(

    @NotBlank
    val name: String,

    @Positive
    val yearGoal: Long
)