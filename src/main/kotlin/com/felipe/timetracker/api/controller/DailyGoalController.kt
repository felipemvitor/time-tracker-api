package com.felipe.timetracker.api.controller

import com.felipe.timetracker.constants.ApiConstants
import com.felipe.timetracker.domain.entity.Goal
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = [ApiConstants.GOAL_URL])
class DailyGoalController {

    @PostMapping("/")
    fun createDailyGoals(goals: ArrayList<Goal>): ResponseEntity<ArrayList<Goal>> {
        return ResponseEntity.ok(goals)
    }

    @GetMapping("/")
    fun getDailyGoals(): ResponseEntity<ArrayList<Goal>> {
        return ResponseEntity.ok(arrayListOf(Goal(null, "Goal name", 0, 0, 0, 0.0)))
    }

}