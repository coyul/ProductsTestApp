package com.coyul.productstestapp.base

import android.content.Context
import androidx.annotation.StringRes

/**
 * @author Koenova Yulia
 */
class ResourceHelper(private val context: Context) {
    fun getString(@StringRes resId: Int): String = context.getString(resId)
}