package com.coyul.productstestapp.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.coyul.productstestapp.domain.interactor.ProductsInteractor
import com.coyul.productstestapp.domain.model.Category
import com.coyul.productstestapp.domain.model.Element
import com.coyul.productstestapp.presentation.converter.CategoriesToElementsConverter
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

class ProductsListViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val productsInteractor: ProductsInteractor = mockk()
    private val converter: CategoriesToElementsConverter = mockk()

    private val elementsObserver: Observer<List<Element>> = spyk()
    private val progressObserver: Observer<Boolean> = spyk()
    private val emptyListObserver: Observer<Unit> = spyk()
    private val errorObserver: Observer<Unit> = spyk()

    private lateinit var viewModel: ProductsListViewModel

    @Before
    fun setUp() {
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        viewModel = ProductsListViewModel(productsInteractor, converter)
        viewModel.elementsLiveData.observeForever(elementsObserver)
        viewModel.progressLiveData.observeForever(progressObserver)
        viewModel.emptyListLiveData.observeForever(emptyListObserver)
        viewModel.errorLiveData.observeForever(errorObserver)
    }

    @Test
    fun `load successful test`() {
        val category = Category(1000L, "some name", "some description", emptyList())
        val testList = listOf(category)
        val testElementList = listOf<Element>(category)
        every { productsInteractor.loadAndSaveCategories() } returns Single.just(listOf(category))
        every { converter.convert(testList) } returns testElementList
        viewModel.load()
        verifySequence {
            progressObserver.onChanged(true)
            elementsObserver.onChanged(testElementList)
            progressObserver.onChanged(false)
        }
    }

    @Test
    fun `load error test`() {
        every { productsInteractor.loadAndSaveCategories() } returns Single.error(Exception("test error"))
        viewModel.load()
        verifySequence {
            progressObserver.onChanged(true)
            errorObserver.onChanged(Unit)
            progressObserver.onChanged(false)
        }
    }

    @Test
    fun `load empty test`() {
        val emptyList = emptyList<Category>()
        every { productsInteractor.loadAndSaveCategories() } returns Single.just(emptyList)
        every { converter.convert(emptyList) } returns emptyList
        viewModel.load()
        verifySequence {
            progressObserver.onChanged(true)
            emptyListObserver.onChanged(Unit)
            progressObserver.onChanged(false)
        }
    }
}