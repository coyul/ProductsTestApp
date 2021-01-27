package com.coyul.productstestapp.domain.repository

import com.coyul.productstestapp.domain.model.Category
import io.reactivex.rxjava3.core.Single

/**
 * Repository for products
 *
 * @author Koenova Yulia
 */
interface ProductsRepository {
     fun getCategoriesWithProducts() : Single<List<Category>>
}