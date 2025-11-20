package com.noovoweb.project.request.string

import com.noovoweb.validator.MaxLength
import com.noovoweb.validator.Validated

@Validated
data class MaxLengthRequest(
    @MaxLength(50)
    val value: String?
)
