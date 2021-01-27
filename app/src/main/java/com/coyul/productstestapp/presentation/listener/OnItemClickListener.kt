package com.coyul.productstestapp.presentation.listener

import com.coyul.productstestapp.domain.model.Element

/**
 * Click listener on elements for adapter
 *
 * @author Koenova Yulia
 */
interface OnItemClickListener<T: Element> {
    fun onClick(element: T)
}