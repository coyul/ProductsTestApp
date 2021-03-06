package com.coyul.productstestapp.presentation.listener

import com.coyul.productstestapp.presentation.model.IdData

/**
 * Listener for opening product details based on ids
 *
 * @author Koenova Yulia
 */
interface ProductDetailsOpenClickListener {
    fun onProductSelected(idData: IdData)
}