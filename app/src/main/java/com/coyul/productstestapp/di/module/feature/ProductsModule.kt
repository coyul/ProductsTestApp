package com.coyul.productstestapp.di.module.feature

import com.coyul.productstestapp.data.repository.ProductsLifeCycleRepositoryImpl
import com.coyul.productstestapp.data.repository.ProductsRepositoryImpl
import com.coyul.productstestapp.domain.interactor.ProductsInteractor
import com.coyul.productstestapp.domain.interactor.ProductsInteractorImpl
import com.coyul.productstestapp.domain.repository.ProductsLifeCycleRepository
import com.coyul.productstestapp.domain.repository.ProductsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ProductsModule {

    @Binds
    abstract fun bindsProductsRepository(repository: ProductsRepositoryImpl): ProductsRepository

    @Binds
    @Singleton
    abstract fun bindsProductsLifeCycleRepository(repository: ProductsLifeCycleRepositoryImpl): ProductsLifeCycleRepository

    @Binds
    abstract fun bindsProductsInteractor(repository: ProductsInteractorImpl): ProductsInteractor
}