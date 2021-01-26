package com.coyul.productstestapp.domain.repository

import com.coyul.productstestapp.data.repository.ProductsLifeCycleRepository
import com.coyul.productstestapp.domain.model.Category

/**
 * @author Koenova Yulia
 */
class ProductsLifeCycleRepositoryImpl : ProductsLifeCycleRepository {

    private lateinit var categories: List<Category>

    override fun saveCategories(categories: List<Category>) {
        this.categories = categories
    }

    override fun getSavedCategories(): List<Category> = categories
}