package com.noovoweb.project.request.string

import com.noovoweb.validator.Lowercase
import com.noovoweb.validator.Validated

@Validated
data class LowercaseRequest(
    @Lowercase
    val value: String?
)
