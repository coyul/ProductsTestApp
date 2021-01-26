package com.coyul.productstestapp.domain.model

/**
 * @author Koenova Yulia
 */
class Product(
    id: Long,
    name: String,
    description: String,
    val imageUrl: String,
    val salePrice: SalePrice
) : Element(id, name, description) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (imageUrl != other.imageUrl) return false
        if (salePrice != other.salePrice) return false

        return true
    }

    override fun hashCode(): Int {
        var result = imageUrl.hashCode()
        result = 31 * result + salePrice.hashCode()
        return result
    }

    override fun toString(): String {
        return "Product(imageUrl='$imageUrl', salePrice=$salePrice) ${super.toString()}"
    }
}