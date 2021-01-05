package com.felipe.timetracker.api.model.request

import javax.validation.constraints.NotNull

data class CategoryIdRequest(@NotNull val id: Long)