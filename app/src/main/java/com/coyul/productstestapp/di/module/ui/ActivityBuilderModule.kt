package com.coyul.productstestapp.di.module.ui

import com.coyul.productstestapp.presentation.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Module for injecting activity
 *
 * @author Koenova Yulia
 */
@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [
            FragmentBuildersModule::class,
            ViewModelModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity
}

