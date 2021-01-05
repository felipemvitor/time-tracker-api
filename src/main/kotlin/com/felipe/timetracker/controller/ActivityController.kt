package com.felipe.timetracker.controller

import com.felipe.timetracker.constants.ApiConstants
import com.felipe.timetracker.entity.Activity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = [ApiConstants.ACTIVITY_URL])
class ActivityController {

    @GetMapping("/")
    fun getvActivities(): ResponseEntity<Activity> {
        return ResponseEntity.ok(Activity(null, "Activity name", 0, 0));
    }

    @PostMapping("/")
    fun createActivities(activities: ArrayList<Activity>): ResponseEntity<ArrayList<Activity>> {
        return ResponseEntity.ok(activities)
    }
}