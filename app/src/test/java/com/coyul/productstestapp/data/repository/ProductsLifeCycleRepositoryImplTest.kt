package com.coyul.productstestapp.data.repository

import com.coyul.productstestapp.domain.model.Category
import com.coyul.productstestapp.domain.repository.ProductsLifeCycleRepository
import org.junit.Assert.assertEquals
import org.junit.Test

class ProductsLifeCycleRepositoryImplTest {

    private val repository: ProductsLifeCycleRepository = ProductsLifeCycleRepositoryImpl()

    @Test
    fun `saveCategories and getCategories Test`() {
        val categories: List<Category> = listOf(Category(ID, TITLE, IMG, emptyList()))
        repository.saveCategories(categories)
        assertEquals(repository.getSavedCategories(), categories)
    }
}

private const val ID = 1000L
private const val TITLE = "Some awesome title"
private const val IMG = "imageLink"