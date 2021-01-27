package com.coyul.productstestapp.presentation.converter

import com.coyul.productstestapp.base.OneWayConverter
import com.coyul.productstestapp.domain.model.Category
import com.coyul.productstestapp.domain.model.Element
import java.util.*
import javax.inject.Inject

/**
 * @author Koenova Yulia
 */
class CategoriesToElementsConverter @Inject constructor() : OneWayConverter<List<Category>, List<Element>> {
    override fun convert(item: List<Category>): List<Element> {
        val elements: MutableList<Element> = ArrayList()
        for (category in item) {
            elements.add(category)
            elements.addAll(category.products)
        }
        return elements
    }
}