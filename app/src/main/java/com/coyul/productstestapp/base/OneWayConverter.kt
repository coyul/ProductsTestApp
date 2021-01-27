package com.coyul.productstestapp.base

/**
 * Interface of converter, that converts entities only one way
 *
 * @author Koenova Yulia
 */
interface OneWayConverter<From, To> {
    fun convert(item: From): To
}