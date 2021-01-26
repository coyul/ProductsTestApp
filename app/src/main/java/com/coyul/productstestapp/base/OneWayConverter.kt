package com.coyul.productstestapp.base

/**
 * @author Koenova Yulia
 */
interface OneWayConverter<From, To> {
    fun convert(item: From): To
}