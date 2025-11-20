package com.noovoweb.project.request.string

import com.noovoweb.validator.Uppercase
import com.noovoweb.validator.Validated

@Validated
data class UppercaseRequest(
    @Uppercase
    val value: String?
)
