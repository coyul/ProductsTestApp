package com.coyul.productstestapp.domain.repository

import com.coyul.productstestapp.domain.model.Category

/**
 * Repository with categories, that is used as DB, working while app is running
 *
 * @author Koenova Yulia
 */
interface CategoriesLifeCycleRepository {
    fun saveCategories(categories: List<Category>)
    fun getSavedCategories(): List<Category>
}