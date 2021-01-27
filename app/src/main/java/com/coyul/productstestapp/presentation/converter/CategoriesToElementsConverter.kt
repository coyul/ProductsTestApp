package com.coyul.productstestapp.presentation.converter

import com.coyul.productstestapp.base.OneWayConverter
import com.coyul.productstestapp.domain.model.Category
import com.coyul.productstestapp.domain.model.Element
import java.util.*
import javax.inject.Inject

/**
 * Converts tree-structured category list into flat-structured elements list
 *
 * For instance:
 * Category1 -> Product1
 *           -> Product2
 * Category3 -> Product3
 * converts into: Category1, Product1, Product2, Category3, Product3
 *
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