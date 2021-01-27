package com.coyul.productstestapp.di

import android.app.Application
import com.coyul.productstestapp.App
import com.coyul.productstestapp.di.module.base.AppModule
import com.coyul.productstestapp.di.module.base.NetworkModule
import com.coyul.productstestapp.di.module.feature.ProductsModule
import com.coyul.productstestapp.di.module.ui.ActivityBuildersModule
import com.coyul.productstestapp.di.module.ui.ViewModelFactoryModule
import com.coyul.productstestapp.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Main dagger component
 *
 * @author Koenova Yulia
 */
@ApplicationScope
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class,
        ViewModelFactoryModule::class,
        AppModule::class,
        NetworkModule::class,
        ProductsModule::class]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}