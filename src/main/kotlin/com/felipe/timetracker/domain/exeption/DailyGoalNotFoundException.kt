package com.felipe.timetracker.domain.exeption

class DailyGoalNotFoundException : EntityNotFoundException {

    constructor(message: String) : super(message)

    constructor(dailyGoalId: Long) : super("No daily goal found with the specified id: $dailyGoalId.")
}