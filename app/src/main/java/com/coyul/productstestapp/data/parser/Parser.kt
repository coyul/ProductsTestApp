package com.coyul.productstestapp.data.parser

import java.io.InputStream
import java.io.OutputStream

/**
 * @author Koenova Yulia
 */
interface Parser {
    fun <T> parse(source: InputStream, clazz: Class<T>): T
    fun serialize(sink: OutputStream, result: Any)
}