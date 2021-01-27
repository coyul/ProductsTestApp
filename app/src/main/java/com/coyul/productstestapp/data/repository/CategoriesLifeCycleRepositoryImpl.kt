package com.coyul.productstestapp.data.repository

import com.coyul.productstestapp.domain.model.Category
import com.coyul.productstestapp.domain.repository.CategoriesLifeCycleRepository
import javax.inject.Inject

/**
 * Default implementation of [CategoriesLifeCycleRepository]
 *
 * @author Koenova Yulia
 */
class CategoriesLifeCycleRepositoryImpl @Inject constructor() : CategoriesLifeCycleRepository {

    private lateinit var categories: List<Category>

    override fun saveCategories(categories: List<Category>) {
        this.categories = categories
    }

    override fun getSavedCategories(): List<Category> = categories
}