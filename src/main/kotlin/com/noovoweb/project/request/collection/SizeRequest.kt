package com.noovoweb.project.request.collection

import com.noovoweb.validator.Size
import com.noovoweb.validator.Validated

@Validated
data class SizeRequest(
    @Size(min = 2, max = 5)
    val items: List<String>?
)
