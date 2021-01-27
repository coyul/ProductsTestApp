package com.coyul.productstestapp.di.module.base

import com.coyul.productstestapp.BuildConfig
import com.coyul.productstestapp.data.api.ProductsApi
import com.coyul.productstestapp.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Module with dependencies for network work
 *
 * @author Koenova Yulia
 */
@Module
class NetworkModule {

    @Provides
    @ApplicationScope
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .baseUrl(BuildConfig.API_URL)
            .build()
    }

    @Provides
    @ApplicationScope
    fun provideProductsApi(retrofit: Retrofit): ProductsApi {
        return retrofit.create(ProductsApi::class.java)
    }
}