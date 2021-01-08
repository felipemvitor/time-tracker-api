package com.felipe.timetracker.api.controller

import com.felipe.timetracker.api.model.request.GoalRequest
import com.felipe.timetracker.api.model.response.GoalResponse
import com.felipe.timetracker.constants.ApiConstants
import com.felipe.timetracker.constants.DatabaseConstants
import com.felipe.timetracker.domain.entity.Goal
import com.felipe.timetracker.domain.repository.GoalRepository
import com.felipe.timetracker.domain.service.GoalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = [ApiConstants.GOAL_URL])
class GoalController {

    @Autowired
    private lateinit var goalRepository: GoalRepository

    @Autowired
    private lateinit var goalService: GoalService

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createGoals(@RequestBody goalsRequest: List<GoalRequest>): List<GoalResponse> {
        val goals = goalsRequest.map { it.toGoal() }

        return goalService.saveAll(goals)
            .map { it.toGoalResponse() }
    }

    @GetMapping
    fun getGoals(): List<GoalResponse> {
        return goalRepository.findAll().map { it.toGoalResponse() }.toList()
    }

    @GetMapping("/{id}")
    fun getGoalById(@PathVariable id: Long): GoalResponse {
        return goalService.findById(id).toGoalResponse()
    }

    @PutMapping("/{id}")
    fun updateGoal(@PathVariable id: Long, goal: Goal): ResponseEntity<GoalResponse> {
        return ResponseEntity.ok(
            DatabaseConstants.fakeGoals.find { it.id == id }!!.toGoalResponse()
        )
    }

    @DeleteMapping("/{id}")
    fun deleteGoal(@PathVariable id: Long): ResponseEntity<Boolean> {
        return ResponseEntity.ok(true)
    }
}