package com.coyul.productstestapp.presentation.converter

import com.coyul.productstestapp.base.OneWayConverter
import com.coyul.productstestapp.domain.model.Category
import com.coyul.productstestapp.domain.model.Element

/**
 * @author Koenova Yulia
 */
class CategoriesToElementsConverter : OneWayConverter <List<Category>, List<Element>> {
    override fun convert(item: List<Category>): List<Element> {
        TODO("Not yet implemented, elements should be from presentation level")
    }
}