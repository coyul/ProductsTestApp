package com.coyul.productstestapp.presentation.converter

import com.coyul.productstestapp.domain.model.Category
import com.coyul.productstestapp.domain.model.Element
import com.coyul.productstestapp.domain.model.Product
import com.coyul.productstestapp.domain.model.SalePrice
import org.junit.Assert.assertEquals
import org.junit.Test

class CategoriesToElementsConverterTest {

    private val converter: CategoriesToElementsConverter = CategoriesToElementsConverter()

    private val salePrice = SalePrice(AMOUNT, CURRENCY)
    private val product1 = Product(ID_1, NAME_1, DESCRIPTION_1, ID_1, IMG_1, salePrice)
    private val product2 = Product(ID_2, NAME_2, DESCRIPTION_2, ID_1, IMG_2, salePrice)
    private val product3 = Product(ID_1, NAME_2, DESCRIPTION_1, ID_2, IMG_1, salePrice)
    private val category1 = Category(ID_1, NAME_1, DESCRIPTION_1, listOf(product1, product2))
    private val category2 = Category(ID_2, NAME_2, DESCRIPTION_2, listOf(product2, product3))

    @Test
    fun convertTest() {
        val listToConvert: List<Category> = listOf(
            category1,
            category2
        )
        val expectedList: List<Element> = listOf(
            category1,
            product1,
            product2,
            category2,
            product2,
            product3
        )
        assertEquals(expectedList, converter.convert(listToConvert))
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