package com.felipe.timetracker.api.controller

import com.felipe.timetracker.api.model.request.ActivityRequest
import com.felipe.timetracker.api.model.response.ActivityResponse
import com.felipe.timetracker.api.model.response.CategoryResponse
import com.felipe.timetracker.constants.ApiConstants
import com.felipe.timetracker.constants.DatabaseConstants
import com.felipe.timetracker.domain.entity.Activity
import com.felipe.timetracker.domain.exeption.BusinessException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(value = [ApiConstants.ACTIVITY_URL])
class ActivityController {

    @PostMapping
    fun createActivities(@RequestBody activities: Array<ActivityRequest>): ResponseEntity<Array<ActivityResponse>> {
        throw BusinessException("Test")
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

    @GetMapping("/{id}")
    fun getActivityById(@PathVariable id: Long): ResponseEntity<ActivityResponse> {
        return ResponseEntity.ok(
            DatabaseConstants.fakeActivities.find { it.id == id }!!.toActivityResponse()
        )
    }

    @GetMapping("/category/{id}")
    fun getActivitiesByCategoryId(@PathVariable id: Long): ResponseEntity<ActivityResponse> {
        return ResponseEntity.ok(
            DatabaseConstants.fakeActivities.find { it.category.id == id }!!.toActivityResponse()
        )
    }

    @PutMapping("/{id}")
    fun updateActivity(@PathVariable id: Long, activity: Activity): ResponseEntity<ActivityResponse> {
        return ResponseEntity.ok(
            DatabaseConstants.fakeActivities.find { it.id == id }!!.toActivityResponse()
        )
    }

    @DeleteMapping("/{id}")
    fun deleteActivity(@PathVariable id: Long): ResponseEntity<Boolean> {
        return ResponseEntity.ok(true)
    }
}