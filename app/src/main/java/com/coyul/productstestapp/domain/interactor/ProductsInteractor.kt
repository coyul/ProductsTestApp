package com.coyul.productstestapp.domain.interactor

import com.coyul.productstestapp.domain.model.Category
import com.coyul.productstestapp.domain.model.Product
import io.reactivex.rxjava3.core.Single

/**
 * @author Koenova Yulia
 */
interface ProductsInteractor {
    fun loadAndSaveCategories() : Single<List<Category>>
    fun getProduct(id: Long, categoryId: Long): Single<Product>
}