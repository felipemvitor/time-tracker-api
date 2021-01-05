package com.felipe.timetracker.api.controller

import com.felipe.timetracker.constants.ApiConstants
import com.felipe.timetracker.domain.entity.Category
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = [ApiConstants.CATEGORY_URL])
class CategoryController {


    @PostMapping("/")
    fun createCategories(category: ArrayList<Category>): ResponseEntity<ArrayList<Category>> {
        return ResponseEntity.ok(category)
    }

    @GetMapping("/")
    fun getCategories(): ResponseEntity<ArrayList<Category>> {
        return ResponseEntity.ok(arrayListOf(Category(null, "Category name", 0, 0, 0.0, 0.0)));
    }

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable id: Long): ResponseEntity<Category> {
        return ResponseEntity.ok(Category(id, "Category name", 0, 0, 0.0, 0.0));
    }

}