package com.noovoweb.project.request.collection

import com.noovoweb.validator.NotContains
import com.noovoweb.validator.Validated

@Validated
data class NotContainsRequest(
    @NotContains("banned")
    val tags: List<String>?
)
