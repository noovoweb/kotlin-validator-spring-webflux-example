package com.noovoweb.project.request.string

import com.noovoweb.validator.EndsWith
import com.noovoweb.validator.Validated

@Validated
data class EndsWithRequest(
    @EndsWith(value = "SUFFIX")
    val value: String?
)
