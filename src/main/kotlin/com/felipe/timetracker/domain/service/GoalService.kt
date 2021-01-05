package com.felipe.timetracker.domain.service

import com.felipe.timetracker.domain.entity.Goal
import com.felipe.timetracker.domain.exeption.GoalNotFoundException
import com.felipe.timetracker.domain.repository.GoalRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class GoalService {

    @Autowired
    private lateinit var goalRepository: GoalRepository

    @Transactional
    fun save(goal: Goal): Goal {
        return goalRepository.save(goal)
    }

    @Transactional
    fun saveAll(activities: ArrayList<Goal>) {
        goalRepository.saveAll(activities)
    }

    @Transactional
    fun deleteById(id: Long) {
        try {
            goalRepository.deleteById(id)
        } catch (e: EmptyResultDataAccessException) {
            throw GoalNotFoundException(id)
        }
    }

    fun findById(id: Long): Goal {
        return goalRepository.findById(id).orElseThrow { GoalNotFoundException(id) }
    }
}