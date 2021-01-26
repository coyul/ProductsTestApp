package com.coyul.productstestapp.domain.model

/**
 * @author Koenova Yulia
 */
class Category(
    id: Long,
    name: String,
    description: String,
    val products: List<Product>
) : Element(id, name, description) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Category) return false
        if (!super.equals(other)) return false
        if (products != other.products) return false
        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + products.hashCode()
        return result
    }

    override fun toString(): String {
        return "Category(products=$products) ${super.toString()}"
    }
}