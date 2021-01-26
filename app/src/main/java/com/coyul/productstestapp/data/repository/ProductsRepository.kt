package com.coyul.productstestapp.data.repository

import com.coyul.productstestapp.domain.model.Category

/**
 * @author Koenova Yulia
 */
interface ProductsRepository {
     fun getCategoriesWithProducts() : List<Category>
}