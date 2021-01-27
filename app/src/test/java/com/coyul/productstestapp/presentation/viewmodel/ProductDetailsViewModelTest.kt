package com.coyul.productstestapp.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.coyul.productstestapp.domain.interactor.ProductsInteractor
import com.coyul.productstestapp.domain.model.Product
import com.coyul.productstestapp.domain.model.SalePrice
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verifySequence
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductDetailsViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val productsInteractor: ProductsInteractor = mockk()

    private val productObserver: Observer<Product> = spyk()
    private val progressObserver: Observer<Boolean> = spyk()

    private lateinit var viewModel: ProductDetailsViewModel

    @Before
    fun setUp() {
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        viewModel = ProductDetailsViewModel(productsInteractor)
        viewModel.productLiveData.observeForever(productObserver)
        viewModel.progressLiveData.observeForever(progressObserver)
    }

    @Test
    fun `load product test`() {
        val id = 1000L
        val categoryId = 2000L
        val product = Product(id, "", "", categoryId, "", SalePrice(0.0, ""))
        every { productsInteractor.getProduct(id, categoryId) } returns Single.just(product)
        viewModel.loadProduct(id, categoryId)
        verifySequence {
            progressObserver.onChanged(true)
            productObserver.onChanged(product)
            progressObserver.onChanged(false)
        }
    }
}