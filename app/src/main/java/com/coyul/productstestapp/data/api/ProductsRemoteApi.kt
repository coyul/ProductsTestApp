package com.coyul.productstestapp.data.api

import com.coyul.productstestapp.data.model.Response
import com.coyul.productstestapp.data.parser.Parser

/**
 * @author Koenova Yulia
 */
class ProductsRemoteApi(private val parser: Parser) : ProductsApi {
    override fun getCategories(): Response {
        TODO("Not yet implemented")
    }
}