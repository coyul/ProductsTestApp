package com.coyul.productstestapp.di.module.base

import com.coyul.productstestapp.data.repository.CategoriesLifeCycleRepositoryImpl
import com.coyul.productstestapp.di.scope.ApplicationScope
import com.coyul.productstestapp.domain.repository.CategoriesLifeCycleRepository
import dagger.Binds
import dagger.Module

/**
 * Module with dependencies needed during all application life time
 *
 * @author Koenova Yulia
 */
@Module
abstract class AppModule {

    @Binds
    @ApplicationScope
    abstract fun bindsProductsLifeCycleRepository(repository: CategoriesLifeCycleRepositoryImpl): CategoriesLifeCycleRepository
}