package com.noovoweb.project.request.string

import com.noovoweb.validator.MinLength
import com.noovoweb.validator.Validated

@Validated
data class MinLengthRequest(
    @MinLength(5)
    val value: String?
)
