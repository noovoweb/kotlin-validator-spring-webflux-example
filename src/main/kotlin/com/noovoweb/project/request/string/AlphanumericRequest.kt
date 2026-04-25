package com.noovoweb.project.request.string

import com.noovoweb.validator.Alphanumeric
import com.noovoweb.validator.Validated

@Validated
data class AlphanumericRequest(
    @Alphanumeric
    val value: String?
)
