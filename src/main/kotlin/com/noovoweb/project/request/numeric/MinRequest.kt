package com.noovoweb.project.request.numeric

import com.noovoweb.validator.Min
import com.noovoweb.validator.Validated

@Validated
data class MinRequest(
    @Min(10.0)
    val value: Double?
)
