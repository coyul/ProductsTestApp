package com.coyul.productstestapp.di.module.ui

import androidx.lifecycle.ViewModelProvider
import com.coyul.productstestapp.presentation.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * Module with dependency for view models factory
 *
 * @author Koenova Yulia
 */
@Module
abstract class ViewModelFactoryModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}