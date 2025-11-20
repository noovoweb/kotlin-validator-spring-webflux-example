package com.noovoweb.project.request.string

import com.noovoweb.validator.Contains
import com.noovoweb.validator.Validated

@Validated
data class ContainsRequest(
    @Contains(value = "keyword")
    val value: String?
)
