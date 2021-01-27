package com.coyul.productstestapp.di.module.ui

import androidx.lifecycle.ViewModel
import com.coyul.productstestapp.presentation.viewmodel.ProductDetailsViewModel
import com.coyul.productstestapp.presentation.viewmodel.ProductsListViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ProductsListViewModel::class)
    internal abstract fun bindProductsListModel(viewModel: ProductsListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProductDetailsViewModel::class)
    internal abstract fun bindProductDetailsViewModel(viewModel: ProductDetailsViewModel): ViewModel
}