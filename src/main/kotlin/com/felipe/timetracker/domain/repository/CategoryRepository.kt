package com.felipe.timetracker.domain.repository

import com.felipe.timetracker.domain.entity.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Long> {
}