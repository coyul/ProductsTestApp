package com.coyul.productstestapp.data.repository

import com.coyul.productstestapp.domain.model.Category

/**
 * @author Koenova Yulia
 */
interface ProductsLifeCycleRepository {
    fun saveCategories(categories: List<Category>)
    fun getSavedCategories(): List<Category>
}