package com.coyul.productstestapp.di.module.ui

import com.coyul.productstestapp.presentation.fragment.ProductDetailsFragment
import com.coyul.productstestapp.presentation.fragment.ProductsListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeProductsListFragment(): ProductsListFragment

    @ContributesAndroidInjector
    abstract fun contributeProductDetailsFragment(): ProductDetailsFragment
}