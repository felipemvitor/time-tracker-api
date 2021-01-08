package com.felipe.timetracker.api.controller

import com.felipe.timetracker.api.model.request.ActivityRequest
import com.felipe.timetracker.api.model.response.ActivityResponse
import com.felipe.timetracker.constants.ApiConstants
import com.felipe.timetracker.constants.DatabaseConstants
import com.felipe.timetracker.domain.entity.Activity
import com.felipe.timetracker.domain.exeption.BusinessException
import com.felipe.timetracker.domain.repository.ActivityRepository
import com.felipe.timetracker.domain.service.ActivityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = [ApiConstants.ACTIVITY_URL])
class ActivityController {

    @Autowired
    private lateinit var activityRepository: ActivityRepository

    @Autowired
    private lateinit var activityService: ActivityService

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createActivities(@RequestBody activitiesRequest: List<ActivityRequest>): List<ActivityResponse> {
        val activities = activitiesRequest.map { it.toActivity() }

        return activityService.saveAll(activities)
            .map {
                it.toActivityResponse()
            }
    }

    @GetMapping
    fun getActivities(): List<ActivityResponse> {
        return activityRepository.findAll().map { it.toActivityResponse() }.toList()
    }

    @GetMapping("/{id}")
    fun getActivityById(@PathVariable id: Long): ActivityResponse {
        return activityService.findById(id).toActivityResponse()
    }

    @GetMapping("/category/{id}")
    fun getActivitiesByCategoryId(@PathVariable id: Long): List<ActivityResponse> {
        return activityService.findByCategoryId(id).map { it.toActivityResponse() }
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