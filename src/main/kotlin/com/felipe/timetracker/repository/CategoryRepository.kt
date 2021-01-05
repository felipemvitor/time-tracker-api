package com.felipe.timetracker.repository

import com.felipe.timetracker.entity.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Long> {
}