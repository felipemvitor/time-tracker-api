package com.felipe.timetracker.domain.service

import com.felipe.timetracker.domain.entity.Category
import com.felipe.timetracker.domain.exeption.CategoryNotFoundException
import com.felipe.timetracker.domain.repository.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class CategoryService {

    @Autowired
    private lateinit var categoryRepository: CategoryRepository

    @Transactional
    fun save(category: Category): Category {
        return categoryRepository.save(category)
    }

    @Transactional
    fun saveAll(activities: ArrayList<Category>) {
        categoryRepository.saveAll(activities)
    }

    @Transactional
    fun deleteById(id: Long) {
        try {
            categoryRepository.deleteById(id)
        } catch (e: EmptyResultDataAccessException) {
            throw CategoryNotFoundException(id)
        }
    }

    fun findById(id: Long): Category {
        return categoryRepository.findById(id).orElseThrow { CategoryNotFoundException(id) }
    }
}