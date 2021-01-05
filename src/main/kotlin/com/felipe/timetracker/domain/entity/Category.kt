package com.felipe.timetracker.domain.entity

import com.felipe.timetracker.constants.DatabaseConstants.CATEGORY_TABLE
import com.felipe.timetracker.constants.DatabaseConstants.DAILY_GOAL
import com.felipe.timetracker.constants.DatabaseConstants.NAME
import com.felipe.timetracker.constants.DatabaseConstants.WEEKLY_GOAL
import com.felipe.timetracker.constants.DatabaseConstants.WOW_GOAL_MULTIPLIER
import com.felipe.timetracker.constants.DatabaseConstants.YEARLY_GOAL
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity(name = CATEGORY_TABLE)
data class Category(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @NotBlank
    @Column(name = NAME)
    var name: String,

    @NotNull
    @Column(name = YEARLY_GOAL)
    var yearGoal: Long,

    @NotNull
    @Column(name = WEEKLY_GOAL)
    var weeklyGoal: Long,

    @NotNull
    @Column(name = DAILY_GOAL)
    var dailyGoal: Double,

    @NotNull
    @Column(name = WOW_GOAL_MULTIPLIER)
    var wowGoalMultiplier: Double

) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Category

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}