package com.coyul.productstestapp.data.parser

import android.util.Log
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.InputStream
import java.io.OutputStream

/**
 * @author Koenova Yulia
 */
class JsonParser(private val objectMapper: ObjectMapper) : Parser {

    override fun <T> parse(source: InputStream, clazz: Class<T>): T =
        try {
            objectMapper.readValue(source, clazz)
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
            throw e
        }

    override fun serialize(sink: OutputStream, result: Any) =
        objectMapper.writeValue(sink, result)

    private companion object {
        private const val TAG = "JsonParser"
    }
}