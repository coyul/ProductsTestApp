package com.coyul.productstestapp.presentation.model

import java.io.Serializable

/**
 * @author Koenova Yulia
 */
data class IdData(
    val id: Long,
    val categoryId: Long
) : Serializable
