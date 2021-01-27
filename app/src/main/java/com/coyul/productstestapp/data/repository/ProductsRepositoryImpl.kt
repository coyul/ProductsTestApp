package com.coyul.productstestapp.data.repository

import com.coyul.productstestapp.data.api.ProductsApi
import com.coyul.productstestapp.domain.converter.ResponseToCategoryConverter
import com.coyul.productstestapp.domain.model.Category
import com.coyul.productstestapp.domain.repository.ProductsRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * @author Koenova Yulia
 */
class ProductsRepositoryImpl @Inject constructor(
    private val productsApi: ProductsApi,
    private val converter: ResponseToCategoryConverter
) : ProductsRepository {

    override fun getCategoriesWithProducts(): Single<List<Category>> =
        productsApi.getCategories()
            .flatMapIterable { it -> it }
            .map { converter.convert(it) }
            .toList()
}