package com.felipe.timetracker.domain.exeption

class CategoryBeingUsedException : EntityBeingUsedException {

    constructor(message: String) : super(message)

    constructor(categoryId: Long) : super("The category id $categoryId is being used on another entity.")
}