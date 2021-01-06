package com.felipe.timetracker.constants

import com.felipe.timetracker.domain.entity.Activity
import com.felipe.timetracker.domain.entity.Category
import com.felipe.timetracker.domain.entity.Goal

object DatabaseConstants {

    // Common attributes
    const val ID = "id"
    const val NAME = "name"
    const val YEARLY_GOAL = "yearly_goal"
    const val WEEKLY_GOAL = "weekly_goal"
    const val DAILY_GOAL = "daily_goal"
    const val WOW_GOAL_MULTIPLIER = "wow_goal_multiplier"

    // Activities
    const val ACTIVITY_TABLE = "activity"
    const val DATE_START = "date_start"
    const val DATE_END = "date_end"
    const val CATEGORY_ID = "category_id"

    // Categories
    const val CATEGORY_TABLE = "category"

    // Goals
    const val GOAL_TABLE = "goal"

    val fakeCategories = arrayOf(
        Category(0, "Sleep", 49 * 52, 49, 49 / 7.0, 2.0),
        Category(1, "Work", 28 * 52, 54, 54 / 7.0, 2.0),
        Category(2, "Study", 28 * 52, 28, 28 / 7.0, 2.0),
        Category(3, "Leisure", 4 * 52, 4, 4 / 7.0, 2.0),
        Category(4, "Housework", 12 * 52, 12, 12 / 7.0, 2.0),
        Category(5, "Breaks", 21 * 52, 21, 21 / 7.0, 2.0)
    )

    val fakeActivities = arrayOf(
        Activity(0, "Course", 1609815600000, 1609821900000, fakeCategories[2]),
        Activity(1, "Sleep", 1609821900000, 1609842600000, fakeCategories[0]),
        Activity(2, "Dishes", 1609842600000, 1609848000000, fakeCategories[4]),
        Activity(3, "Company", 1609848000000, 1609860600000, fakeCategories[1]),
        Activity(4, "Lunch", 1609860600000, 1609862400000, fakeCategories[5]),
        Activity(5, "Course", 1609862400000, 1609864200000, fakeCategories[2]),
        Activity(6, "Company", 1609864200000, 1609880400000, fakeCategories[1]),
        Activity(7, "Cleaning", 1609880400000, 1609883100000, fakeCategories[4]),
        Activity(8, "Course", 1609883100000, 1609884000000, fakeCategories[2]),
        Activity(9, "Class", 1609884000000, 1609887600000, fakeCategories[2]),
    )

    val fakeGoals = arrayOf(
        Goal(0, "Commits", 1000, 1000 / 52, 100 / 52 / 7, 2.0)
    )
}