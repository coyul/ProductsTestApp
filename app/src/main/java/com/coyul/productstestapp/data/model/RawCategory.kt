package com.coyul.productstestapp.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author Koenova Yulia
 */
data class RawCategory (
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("products") val themes: List<RawProduct>
)

data class RawProduct(
    @SerializedName("id") val id: String,
    @SerializedName("categoryId") val categoryId: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("url") val url: String,
    @SerializedName("salePrice") val salePrice: RawSalePrice
)

data class RawSalePrice(
    @SerializedName("amount") val amount: String,
    @SerializedName("currency") val currency: String,
)