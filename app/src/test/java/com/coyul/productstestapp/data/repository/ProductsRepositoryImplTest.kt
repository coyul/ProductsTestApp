package com.coyul.productstestapp.data.repository

import com.coyul.productstestapp.data.api.ProductsApi
import com.coyul.productstestapp.data.model.RawCategory
import com.coyul.productstestapp.domain.converter.ResponseToCategoryConverter
import com.coyul.productstestapp.domain.model.Category
import com.coyul.productstestapp.domain.repository.ProductsRepository
import io.mockk.every
import io.mockk.mockk
import io.reactivex.rxjava3.core.Observable
import org.junit.Test

class ProductsRepositoryImplTest {

    private val productsApi: ProductsApi = mockk()
    private val converter: ResponseToCategoryConverter = mockk()

    private val repository: ProductsRepository = ProductsRepositoryImpl(productsApi, converter)

    @Test
    fun `getCategoriesWithProducts test`() {
        val rawCategory = RawCategory(ID_TEXT, NAME, IMG, emptyList())
        val category = Category(ID, NAME, IMG, emptyList())
        every { productsApi.getCategories() } returns Observable.just(listOf(rawCategory))
        every { converter.convert(rawCategory) } returns category
        repository.getCategoriesWithProducts()
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertResult(listOf(category))
    }
}

private const val ID = 1000L
private const val ID_TEXT = "1000"
private const val NAME = "Some awesome name"
private const val IMG = "imageLink"