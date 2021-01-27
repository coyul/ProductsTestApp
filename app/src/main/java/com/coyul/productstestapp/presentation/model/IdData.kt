package com.coyul.productstestapp.presentation.model

import java.io.Serializable

/**
 * Data for opening product details screen from list
 *
 * @author Koenova Yulia
 */
data class IdData(
    val id: Long,
    val categoryId: Long
) : Serializable
