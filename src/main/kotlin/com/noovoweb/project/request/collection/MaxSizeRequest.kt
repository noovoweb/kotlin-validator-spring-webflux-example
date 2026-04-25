package com.noovoweb.project.request.collection

import com.noovoweb.validator.MaxSize
import com.noovoweb.validator.Validated

@Validated
data class MaxSizeRequest(
    @MaxSize(5)
    val items: List<String>?
)
