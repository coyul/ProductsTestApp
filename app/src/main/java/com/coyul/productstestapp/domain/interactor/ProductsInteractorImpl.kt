package com.coyul.productstestapp.domain.interactor

import com.coyul.productstestapp.data.repository.ProductsLifeCycleRepository
import com.coyul.productstestapp.data.repository.ProductsRepository
import com.coyul.productstestapp.domain.model.Category
import com.coyul.productstestapp.domain.model.Product

/**
 * @author Koenova Yulia
 */
class ProductsInteractorImpl(
    private val productsRepository: ProductsRepository,
    private val productsLifeCycleRepository: ProductsLifeCycleRepository
) : ProductsInteractor {

    override fun loadAndSaveCategories(): List<Category> {
        TODO("Not yet implemented")
    }

    override fun getProduct(id: Long): Product {
        TODO("Not yet implemented")
    }
}