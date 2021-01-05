package com.felipe.timetracker.entity

import com.felipe.timetracker.constants.DatabaseConstants.CATEGORY_TABLE
import com.felipe.timetracker.constants.DatabaseConstants.DAILY_GOAL
import com.felipe.timetracker.constants.DatabaseConstants.NAME
import com.felipe.timetracker.constants.DatabaseConstants.WEEKLY_GOAL
import com.felipe.timetracker.constants.DatabaseConstants.WOW_GOAL_MULTIPLIER
import com.felipe.timetracker.constants.DatabaseConstants.YEARLY_GOAL
import java.io.Serializable
import javax.persistence.*

@Entity(name = CATEGORY_TABLE)
data class Category(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(name = NAME)
    var name: String,

    @Column(name = YEARLY_GOAL)
    var yearGoal: Long,

    @Column(name = WEEKLY_GOAL)
    var weeklyGoal: Long,

    @Column(name = DAILY_GOAL)
    var dailyGoal: Double,

    @Column(name = WOW_GOAL_MULTIPLIER)
    var wowGoalMultiplier: Double

) : Serializable