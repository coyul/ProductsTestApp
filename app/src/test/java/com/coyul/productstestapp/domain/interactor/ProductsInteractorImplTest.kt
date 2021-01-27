package com.coyul.productstestapp.domain.interactor

import com.coyul.productstestapp.domain.model.Category
import com.coyul.productstestapp.domain.model.Product
import com.coyul.productstestapp.domain.model.SalePrice
import com.coyul.productstestapp.domain.repository.ProductsLifeCycleRepository
import com.coyul.productstestapp.domain.repository.ProductsRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test

class ProductsInteractorImplTest {

    private val productsRepository: ProductsRepository = mockk()
    private val productsLifeCycleRepository: ProductsLifeCycleRepository = mockk()
    private val interactor: ProductsInteractor =
        ProductsInteractorImpl(productsRepository, productsLifeCycleRepository)

    private val salePrice = SalePrice(AMOUNT, CURRENCY)
    private val product1 = Product(ID_1, NAME_1, DESCRIPTION_1, ID_1, IMG_1, salePrice)
    private val product2 = Product(ID_2, NAME_2, DESCRIPTION_2, ID_1, IMG_2, salePrice)
    private val testList: List<Category> =
        listOf(Category(ID_1, NAME_1, DESCRIPTION_1, listOf(product1, product2)))

    @Before
    fun setUp() {
    }

    @Test
    fun `loadAndSaveCategories test`() {
        every { productsRepository.getCategoriesWithProducts() } returns Single.just(testList)
        every { productsLifeCycleRepository.saveCategories(testList) } returns Unit
        interactor.loadAndSaveCategories()
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertResult(testList)
        verify {
            productsLifeCycleRepository.saveCategories(testList)
        }
    }

    @Test
    fun `getProduct test`() {
        every { productsLifeCycleRepository.getSavedCategories() } returns testList
        interactor.getProduct(ID_2, ID_1)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertResult(product2)
    }
}

private const val ID_1 = 1000L
private const val ID_2 = 2000L

private const val NAME_1 = "Some awesome name 1"
private const val NAME_2 = "Some awesome name 2"

private const val IMG_1 = "imageLink1"
private const val IMG_2 = "imageLink2"

private const val DESCRIPTION_1 = "some awesome description 1"
private const val DESCRIPTION_2 = "some awesome description 2"

private const val AMOUNT = 1000.1
private const val CURRENCY = "euro"