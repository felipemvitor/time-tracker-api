package com.felipe.timetracker.api.controller

import com.felipe.timetracker.constants.ApiConstants
import com.felipe.timetracker.domain.entity.DailyGoal
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = [ApiConstants.DAILY_GOAL_URL])
class DailyGoalController {

    @PostMapping("/")
    fun createDailyGoals(goals: ArrayList<DailyGoal>): ResponseEntity<ArrayList<DailyGoal>> {
        return ResponseEntity.ok(goals)
    }

    @GetMapping("/")
    fun getDailyGoals(): ResponseEntity<ArrayList<DailyGoal>> {
        return ResponseEntity.ok(arrayListOf(DailyGoal(null, "Goal name", 0, 0, 0, 0.0)))
    }

}