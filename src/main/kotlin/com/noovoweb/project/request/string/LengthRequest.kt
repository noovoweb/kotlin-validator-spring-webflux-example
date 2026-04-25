package com.noovoweb.project.request.string

import com.noovoweb.validator.Length
import com.noovoweb.validator.Validated

@Validated
data class LengthRequest(
    @Length(min = 3, max = 20)
    val value: String?
)
