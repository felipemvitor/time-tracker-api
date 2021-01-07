package com.felipe.timetracker.api.controller

import com.felipe.timetracker.api.model.request.CategoryRequest
import com.felipe.timetracker.api.model.response.CategoryResponse
import com.felipe.timetracker.constants.ApiConstants
import com.felipe.timetracker.constants.DatabaseConstants
import com.felipe.timetracker.domain.entity.Category
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = [ApiConstants.CATEGORY_URL])
class CategoryController {


    @PostMapping
    fun createCategories(categories: List<CategoryRequest>): ResponseEntity<List<CategoryResponse>> {
        return ResponseEntity.ok(DatabaseConstants.fakeCategories.map {
            it.toCategoryResponse()
        })
    }

    @GetMapping
    fun getCategories(): ResponseEntity<List<CategoryResponse>> {
        return ResponseEntity.ok(DatabaseConstants.fakeCategories.map { it.toCategoryResponse() })
    }

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable id: Long): ResponseEntity<CategoryResponse> {
        return ResponseEntity.ok(
            DatabaseConstants.fakeCategories
                .find { it.id == id }!!
                .toCategoryResponse()
        )
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