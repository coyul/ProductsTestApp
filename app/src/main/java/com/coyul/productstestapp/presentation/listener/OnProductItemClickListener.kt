package com.coyul.productstestapp.presentation.listener

import com.coyul.productstestapp.presentation.model.IdData

interface OnProductItemClickListener {
    fun onProductSelected(idData: IdData)
}