package com.coyul.productstestapp.data.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author Koenova Yulia
 */
data class Response @JsonCreator constructor(
    @param:JsonProperty("blocks") val blocks: List<Category>
)

data class Category @JsonCreator constructor(
    @param:JsonProperty("id") val id: String,
    @param:JsonProperty("name") val name: String,
    @param:JsonProperty("description") val description: String,
    @param:JsonProperty("products") val themes: List<Product>
)

data class Product @JsonCreator constructor(
    @param:JsonProperty("id") val id: String,
    @param:JsonProperty("categoryId") val categoryId: String,
    @param:JsonProperty("name") val name: String,
    @param:JsonProperty("description") val description: String,
    @param:JsonProperty("url") val url: String,
    @param:JsonProperty("salePrice") val salePrice: SalePrice
)

data class SalePrice @JsonCreator constructor(
    @param:JsonProperty("amount") val amount: String,
    @param:JsonProperty("currency") val currency: String,
)