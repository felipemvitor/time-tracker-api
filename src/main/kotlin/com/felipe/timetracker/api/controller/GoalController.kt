package com.felipe.timetracker.api.controller

import com.felipe.timetracker.api.model.request.GoalRequest
import com.felipe.timetracker.api.model.response.GoalResponse
import com.felipe.timetracker.constants.ApiConstants
import com.felipe.timetracker.constants.DatabaseConstants
import com.felipe.timetracker.domain.entity.Goal
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = [ApiConstants.GOAL_URL])
class GoalController {

    @PostMapping
    fun createDailyGoals(goals: List<GoalRequest>): ResponseEntity<List<GoalResponse>> {
        return ResponseEntity.ok(DatabaseConstants.fakeGoals.map { it.toGoalResponse() })
    }

    @GetMapping
    fun getDailyGoals(): ResponseEntity<List<GoalResponse>> {
        return ResponseEntity.ok(DatabaseConstants.fakeGoals.map { it.toGoalResponse() })
    }

}