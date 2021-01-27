package com.coyul.productstestapp.presentation.listener

import com.coyul.productstestapp.domain.model.Element

interface OnItemClickListener<T: Element> {
    fun onClick(element: T)
}