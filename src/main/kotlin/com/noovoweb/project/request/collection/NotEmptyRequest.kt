package com.noovoweb.project.request.collection

import com.noovoweb.validator.NotEmpty
import com.noovoweb.validator.Validated

@Validated
data class NotEmptyRequest(
    @NotEmpty
    val items: List<String>?
)
