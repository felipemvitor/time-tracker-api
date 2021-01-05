package com.felipe.timetracker.domain.exeption

class CategoryNotFoundException : EntityNotFoundException {

    constructor(message: String) : super(message)

    constructor(categoryId: Long) : super("No category found with the specified id: $categoryId.")
}