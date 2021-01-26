package com.coyul.productstestapp.domain.repository

import com.coyul.productstestapp.data.api.ProductsApi
import com.coyul.productstestapp.data.repository.ProductsRepository
import com.coyul.productstestapp.domain.converter.ResponseToCategoriesConverter
import com.coyul.productstestapp.domain.model.Category

/**
 * @author Koenova Yulia
 */
class ProductsRepositoryImpl(
    private val productsApi: ProductsApi,
    private val converter: ResponseToCategoriesConverter
) : ProductsRepository {

    override fun getCategoriesWithProducts(): List<Category> {
        TODO("Not yet implemented")
    }
}