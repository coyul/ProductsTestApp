package com.coyul.productstestapp.domain.converter

import com.coyul.productstestapp.data.model.RawCategory
import com.coyul.productstestapp.data.model.RawProduct
import com.coyul.productstestapp.data.model.RawSalePrice
import com.coyul.productstestapp.domain.model.Category
import com.coyul.productstestapp.domain.model.Product
import com.coyul.productstestapp.domain.model.SalePrice
import org.junit.Assert.assertEquals
import org.junit.Test

class ResponseToCategoriesConverterTest {

    private val converter = ResponseToCategoryConverter()

    @Test
    fun `convert Test`() {
        assertEquals(
            converter.convert(
                RawCategory(
                    ID_1_TEXT, NAME_1, DESCRIPTION_1, listOf(
                        RawProduct(
                            ID_1_TEXT, ID_1_TEXT, NAME_1, DESCRIPTION_1, IMG_1,
                            RawSalePrice(AMOUNT_TEXT, CURRENCY_1)
                        ),
                        RawProduct(
                            ID_2_TEXT, ID_1_TEXT, NAME_2, DESCRIPTION_2, IMG_2,
                            RawSalePrice(AMOUNT_TEXT, CURRENCY_2)
                        ),
                    )
                )
            ),
            Category(
                ID_1, NAME_1, DESCRIPTION_1, listOf(
                    Product(
                        ID_1, NAME_1, DESCRIPTION_1, ID_1, IMG_RESULT_1,
                        SalePrice(AMOUNT, CURRENCY_1)
                    ),
                    Product(
                        ID_2, NAME_2, DESCRIPTION_2, ID_1, IMG_RESULT_2,
                        SalePrice(AMOUNT, CURRENCY_2)
                    ),
                )
            )
        )
    }

    @Test
    fun `convert corner cases Test`() {
        assertEquals(
            converter.convert(
                RawCategory(
                    ID_INCORRECT_TEXT, NAME_2, DESCRIPTION_2, listOf(
                        RawProduct(
                            ID_INCORRECT_TEXT, ID_INCORRECT_TEXT, NAME_1, DESCRIPTION_2, IMG_1,
                            RawSalePrice(AMOUNT_INCORRECT_TEXT, CURRENCY_1)
                        )
                    )
                )
            ),
            Category(
                ID_INCORRECT, NAME_2, DESCRIPTION_2, listOf(
                    Product(
                        ID_INCORRECT, NAME_1, DESCRIPTION_2, ID_INCORRECT, IMG_RESULT_1,
                        SalePrice(AMOUNT_INCORRECT, CURRENCY_1)
                    )
                )
            )
        )
    }

}

private const val ID_1 = 1000L
private const val ID_2 = 2000L
private const val ID_INCORRECT = 0L

private const val ID_1_TEXT = "1000"
private const val ID_2_TEXT = "2000"
private const val ID_INCORRECT_TEXT = "a"

private const val NAME_1 = "Some awesome name 1"
private const val NAME_2 = "Some awesome name 2"

private const val IMG_1 = "imageLink1"
private const val IMG_2 = "imageLink2"

private const val IMG_RESULT_1 = "http://mobcategories.s3-website-eu-west-1.amazonaws.comimageLink1"
private const val IMG_RESULT_2 = "http://mobcategories.s3-website-eu-west-1.amazonaws.comimageLink2"

private const val DESCRIPTION_1 = "some awesome description 1"
private const val DESCRIPTION_2 = "some awesome description 2"

private const val AMOUNT = 1000.1
private const val AMOUNT_INCORRECT = 0.0

private const val AMOUNT_TEXT = "1000.1"
private const val AMOUNT_INCORRECT_TEXT = "aaa"

private const val CURRENCY_1 = "euro"
private const val CURRENCY_2 = "no"