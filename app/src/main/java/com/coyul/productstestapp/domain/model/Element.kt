package com.coyul.productstestapp.domain.model

abstract class Element(
    val id: Long,
    val name: String,
    val description: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Element) return false
        if (id != other.id) return false
        if (name != other.name) return false
        if (description != other.description) return false
        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + description.hashCode()
        return result
    }

    override fun toString(): String {
        return "Element(id=$id, name='$name', description='$description')"
    }
}