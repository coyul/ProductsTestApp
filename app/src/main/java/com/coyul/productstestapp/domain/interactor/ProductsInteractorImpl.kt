package com.coyul.productstestapp.domain.interactor

import com.coyul.productstestapp.domain.model.Category
import com.coyul.productstestapp.domain.model.Product
import com.coyul.productstestapp.domain.repository.CategoriesLifeCycleRepository
import com.coyul.productstestapp.domain.repository.ProductsRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * Default implementation of [ProductsInteractor]
 *
 * @author Koenova Yulia
 */
class ProductsInteractorImpl @Inject constructor(
    private val productsRepository: ProductsRepository,
    private val categoriesLifeCycleRepository: CategoriesLifeCycleRepository
) : ProductsInteractor {

    override fun loadAndSaveCategories(): Single<List<Category>> =
        productsRepository.getCategoriesWithProducts()
            .doOnSuccess { categoriesLifeCycleRepository.saveCategories(it) }

    override fun getProduct(id: Long, categoryId: Long): Single<Product> {
        return Single.fromCallable {
            categoriesLifeCycleRepository.getSavedCategories()
                .find { it.id == categoryId }
                ?.products
                ?.find { it.id == id }
        }
    }
}