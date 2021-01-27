package com.coyul.productstestapp.domain.converter

import com.coyul.productstestapp.BuildConfig
import com.coyul.productstestapp.base.OneWayConverter
import com.coyul.productstestapp.data.model.RawCategory
import com.coyul.productstestapp.data.model.RawProduct
import com.coyul.productstestapp.data.model.RawSalePrice
import com.coyul.productstestapp.domain.model.Category
import com.coyul.productstestapp.domain.model.Product
import com.coyul.productstestapp.domain.model.SalePrice
import java.util.*
import javax.inject.Inject

/**
 * Converts raw response from server into model, convenient for using through the app
 *
 * @author Koenova Yulia
 */
class ResponseToCategoryConverter @Inject constructor() : OneWayConverter<RawCategory, Category> {

    override fun convert(item: RawCategory): Category =
        Category(
            item.id.toLongOrNull() ?: DEFAULT_ID,
            item.name,
            item.description,
            convertProducts(item.themes)
        )

    private fun convertProducts(products: List<RawProduct>): List<Product> =
        products.map {
            Product(
                it.id.toLongOrNull() ?: DEFAULT_ID,
                it.name,
                it.description,
                it.categoryId.toLongOrNull() ?: DEFAULT_ID,
                BuildConfig.API_URL + it.url,
                convertPrice(it.salePrice)
            )
        }

    private fun convertPrice(price: RawSalePrice): SalePrice =
        SalePrice(
            price.amount.toDoubleOrNull() ?: DEFAULT_AMOUNT,
            getCurrencySymbolIfPossible(price.currency)
        )

    private fun getCurrencySymbolIfPossible(currencyCode: String): String {
        return try {
            Currency.getInstance(currencyCode).getSymbol(Locale.getDefault())
        } catch (e: Exception) {
            currencyCode
        }
    }

    private companion object {
        private const val DEFAULT_ID = 0L
        private const val DEFAULT_AMOUNT = 0.0
    }
}