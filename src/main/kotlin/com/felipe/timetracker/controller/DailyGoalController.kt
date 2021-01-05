package com.felipe.timetracker.controller

import com.felipe.timetracker.constants.ApiConstants
import com.felipe.timetracker.entity.DailyGoal
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = [ApiConstants.DAILY_GOAL_URL])
class DailyGoalController {

    @GetMapping("/")
    fun getDailyGoals(): ResponseEntity<DailyGoal> {
        return ResponseEntity.ok(DailyGoal(null, "Goal name", 0, 0, 0, 0.0))
    }

    @PostMapping("/")
    fun createDailyGoals(goals: ArrayList<DailyGoal>): ResponseEntity<ArrayList<DailyGoal>> {
        return ResponseEntity.ok(goals)
    }
}