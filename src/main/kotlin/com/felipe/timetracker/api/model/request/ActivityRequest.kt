package com.felipe.timetracker.api.model.request

import com.felipe.timetracker.domain.entity.Activity
import com.felipe.timetracker.domain.entity.Category
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class ActivityRequest(

    @NotBlank
    val name: String,

    @Positive
    val dateStart: Long,

    @Positive
    val dateEnd: Long,

    @NotNull
    val category: CategoryIdRequest
) {

    fun toActivity(): Activity {
        return Activity(null, name, dateStart, dateEnd, Category(category.id))
    }
}