package com.coyul.productstestapp.data.repository

import com.coyul.productstestapp.domain.model.Category
import com.coyul.productstestapp.domain.repository.ProductsLifeCycleRepository
import javax.inject.Inject

/**
 * Default implementation of [ProductsLifeCycleRepository]
 *
 * @author Koenova Yulia
 */
class ProductsLifeCycleRepositoryImpl @Inject constructor() : ProductsLifeCycleRepository {

    private lateinit var categories: List<Category>

    override fun saveCategories(categories: List<Category>) {
        this.categories = categories
    }

    override fun getSavedCategories(): List<Category> = categories
}