package com.coyul.productstestapp.domain.converter

import com.coyul.productstestapp.base.OneWayConverter
import com.coyul.productstestapp.data.model.Response
import com.coyul.productstestapp.domain.model.Category

/**
 * @author Koenova Yulia
 */
class ResponseToCategoriesConverter : OneWayConverter<Response, List<Category>> {
    override fun convert(item: Response): List<Category> {
        TODO("Not yet implemented")
    }
}