package com.coyul.productstestapp.data.api

import com.coyul.productstestapp.data.model.RawCategory
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

/**
 * @author Koenova Yulia
 */
interface ProductsApi {

    @GET(".")
    fun getCategories(): Observable<List<RawCategory>>
}