package com.felipe.timetracker.domain.service

import com.felipe.timetracker.domain.entity.Activity
import com.felipe.timetracker.domain.exeption.ActivityNotFoundException
import com.felipe.timetracker.domain.repository.ActivityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class ActivityService {

    @Autowired
    private lateinit var activityRepository: ActivityRepository

    @Transactional
    fun save(activity: Activity): Activity {
        return activityRepository.save(activity)
    }

    @Transactional
    fun saveAll(activities: List<Activity>): List<Activity> {
        return activityRepository.saveAll(activities)
    }

    fun findById(id: Long): Activity {
        return activityRepository.findById(id).orElseThrow { ActivityNotFoundException(id) }
    }

    fun findByCategoryId(id: Long): List<Activity> {
        return activityRepository.findActivitiesByCategoryId(id)
    }

    @Transactional
    fun deleteById(id: Long) {
        try {
            activityRepository.deleteById(id)
        } catch (e: EmptyResultDataAccessException) {
            throw ActivityNotFoundException(id)
        }
    }

}