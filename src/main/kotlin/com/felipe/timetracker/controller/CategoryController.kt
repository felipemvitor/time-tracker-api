package com.felipe.timetracker.controller

import com.felipe.timetracker.constants.ApiConstants
import com.felipe.timetracker.entity.Category
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = [ApiConstants.CATEGORY_URL])
class CategoryController {

    @GetMapping("/")
    fun getCategories(): ResponseEntity<Category> {
        return ResponseEntity.ok(Category(null, "Category name", 0, 0, 0.0, 0.0));
    }

    @PostMapping("/")
    fun createCategories(category: ArrayList<Category>): ResponseEntity<ArrayList<Category>> {
        return ResponseEntity.ok(category)
    }
}