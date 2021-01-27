package com.coyul.productstestapp.domain.model

class Product(
    id: Long,
    name: String,
    description: String,
    val categoryId: Long,
    val imageUrl: String,
    val salePrice: SalePrice
) : Element(id, name, description) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Product) return false
        if (!super.equals(other)) return false

        if (categoryId != other.categoryId) return false
        if (imageUrl != other.imageUrl) return false
        if (salePrice != other.salePrice) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + categoryId.hashCode()
        result = 31 * result + imageUrl.hashCode()
        result = 31 * result + salePrice.hashCode()
        return result
    }

    override fun toString(): String {
        return "Product(categoryId=$categoryId, imageUrl='$imageUrl', salePrice=$salePrice) ${super.toString()}"
    }
}