package com.coyul.productstestapp.presentation.listener

import com.coyul.productstestapp.domain.model.Product

/**
 * Click listener on elements for adapter
 *
 * @author Koenova Yulia
 */
interface OnProductItemClickListener {
    fun onClick(product: Product)
}