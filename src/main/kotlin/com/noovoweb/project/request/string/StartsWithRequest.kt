package com.noovoweb.project.request.string

import com.noovoweb.validator.StartsWith
import com.noovoweb.validator.Validated

@Validated
data class StartsWithRequest(
    @StartsWith(value = "PREFIX")
    val value: String?
)
