package com.felipe.timetracker.api.controller

import com.felipe.timetracker.api.model.request.ActivityRequest
import com.felipe.timetracker.api.model.response.ActivityResponse
import com.felipe.timetracker.api.model.response.CategoryResponse
import com.felipe.timetracker.constants.ApiConstants
import com.felipe.timetracker.constants.DatabaseConstants
import com.felipe.timetracker.domain.entity.Activity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = [ApiConstants.ACTIVITY_URL])
class ActivityController {

    @PostMapping
    fun createActivities(activities: Array<ActivityRequest>): ResponseEntity<Array<ActivityResponse>> {
        return ResponseEntity.ok(
            DatabaseConstants.fakeActivities.map {
                it.toActivityResponse()
            }.toTypedArray()
        )
    }

    @GetMapping
    fun getActivities(): ResponseEntity<List<ActivityResponse>> {
        return ResponseEntity.ok(
            DatabaseConstants.fakeActivities.map {
                it.toActivityResponse()
            }
        )
    }
}