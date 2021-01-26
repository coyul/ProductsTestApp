package com.coyul.productstestapp.data.api

import com.coyul.productstestapp.data.model.Response

/**
 * @author Koenova Yulia
 */
interface ProductsApi {
    fun getCategories(): Response
}