package com.coyul.productstestapp.domain.interactor

import com.coyul.productstestapp.domain.model.Category
import com.coyul.productstestapp.domain.model.Product

/**
 * @author Koenova Yulia
 */
interface ProductsInteractor {
    fun loadAndSaveCategories() : List<Category>
    fun getProduct(id: Long): Product
}