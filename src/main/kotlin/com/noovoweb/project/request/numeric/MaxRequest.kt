package com.noovoweb.project.request.numeric

import com.noovoweb.validator.Max
import com.noovoweb.validator.Validated

@Validated
data class MaxRequest(
    @Max(100.0)
    val value: Double?
)
