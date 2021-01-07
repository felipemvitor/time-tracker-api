package com.felipe.timetracker.api.controller

import com.felipe.timetracker.api.model.request.CategoryRequest
import com.felipe.timetracker.api.model.response.CategoryResponse
import com.felipe.timetracker.constants.ApiConstants
import com.felipe.timetracker.constants.DatabaseConstants
import com.felipe.timetracker.domain.entity.Category
import com.felipe.timetracker.domain.repository.CategoryRepository
import com.felipe.timetracker.domain.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(value = [ApiConstants.CATEGORY_URL])
class CategoryController {

    @Autowired
    private lateinit var categoryRepository: CategoryRepository

    @Autowired
    private lateinit var categoryService: CategoryService

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCategories(@RequestBody categoriesRequest: List<CategoryRequest>): List<CategoryResponse> {
        val categories = categoriesRequest.map { it.toCategory() }

        return categoryService.saveAll(categories)
            .map { it.toCategoryResponse() }
    }

    @GetMapping
    fun getCategories(): List<CategoryResponse> {
        return categoryRepository.findAll().map { it.toCategoryResponse() }.toList()
    }

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable id: Long): CategoryResponse {
         return categoryService.findById(id).toCategoryResponse()
    }

    @PutMapping("/{id}")
    fun updateCategory(@PathVariable id: Long, category: Category): ResponseEntity<CategoryResponse> {
        return ResponseEntity.ok(
            DatabaseConstants.fakeCategories.find { it.id == id }!!.toCategoryResponse()
        )
    }

    @DeleteMapping("/{id}")
    fun deleteActivity(@PathVariable id: Long): ResponseEntity<Boolean> {
        return ResponseEntity.ok(true)
    }

}