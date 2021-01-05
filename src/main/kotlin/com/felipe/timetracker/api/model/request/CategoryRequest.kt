package com.felipe.timetracker.api.model.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

data class CategoryRequest(

    @NotBlank
    var name: String,

    @Positive
    var yearGoal: Long
)