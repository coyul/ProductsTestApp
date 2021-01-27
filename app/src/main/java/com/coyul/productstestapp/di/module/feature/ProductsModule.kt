package com.coyul.productstestapp.di.module.feature

import com.coyul.productstestapp.data.repository.ProductsRepositoryImpl
import com.coyul.productstestapp.domain.interactor.ProductsInteractor
import com.coyul.productstestapp.domain.interactor.ProductsInteractorImpl
import com.coyul.productstestapp.domain.repository.ProductsRepository
import dagger.Binds
import dagger.Module

/**
 * Module with dependencies for products list and details feature
 *
 * @author Koenova Yulia
 */
@Module
abstract class ProductsModule {

    @Binds
    abstract fun bindsProductsRepository(repository: ProductsRepositoryImpl): ProductsRepository

    @Binds
    abstract fun bindsProductsInteractor(repository: ProductsInteractorImpl): ProductsInteractor
}