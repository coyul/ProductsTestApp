package com.coyul.productstestapp.domain.converter

import com.coyul.productstestapp.BuildConfig
import com.coyul.productstestapp.base.OneWayConverter
import com.coyul.productstestapp.data.model.RawCategory
import com.coyul.productstestapp.data.model.RawProduct
import com.coyul.productstestapp.data.model.RawSalePrice
import com.coyul.productstestapp.domain.model.Category
import com.coyul.productstestapp.domain.model.Product
import com.coyul.productstestapp.domain.model.SalePrice
import javax.inject.Inject

/**
 * @author Koenova Yulia
 */
class ResponseToCategoryConverter @Inject constructor() : OneWayConverter<RawCategory, Category> {

    //TODO make 0 into constants

    override fun convert(item: RawCategory): Category =
        Category(
            item.id.toLongOrNull() ?: 0L,
            item.name,
            item.description,
            convertProducts(item.themes)
        )

    private fun convertProducts(products: List<RawProduct>): List<Product> =
        products.map {
            Product(
                it.id.toLongOrNull() ?: 0L,
                it.name,
                it.description,
                it.categoryId.toLongOrNull() ?: 0L,
                BuildConfig.API_URL + it.url,
                convertPrice(it.salePrice)
            )
        }

    private fun convertPrice(price: RawSalePrice): SalePrice =
        SalePrice(
            price.amount.toDoubleOrNull() ?: 0.0,
            //TODO normal currency!
            price.currency
        )
}