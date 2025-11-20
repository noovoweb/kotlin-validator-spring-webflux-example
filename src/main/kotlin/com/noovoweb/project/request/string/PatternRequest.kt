package com.noovoweb.project.request.string

import com.noovoweb.validator.Pattern
import com.noovoweb.validator.Validated

@Validated
data class PatternRequest(
    @Pattern(value = "^[A-Z][a-z]+$")
    val value: String?
)
