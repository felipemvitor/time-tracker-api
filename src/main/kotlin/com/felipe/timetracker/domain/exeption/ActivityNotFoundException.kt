package com.felipe.timetracker.domain.exeption

class ActivityNotFoundException : EntityNotFoundException {

    constructor(message: String) : super(message)

    constructor(activityId: Long) : super("No activity found with the specified id: $activityId.")
}