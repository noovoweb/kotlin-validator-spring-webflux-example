package com.noovoweb.project.request.collection

import com.noovoweb.validator.Distinct
import com.noovoweb.validator.Validated

@Validated
data class DistinctRequest(
    @Distinct
    val values: List<String>?
)
