package com.noovoweb.project.request.numeric

import com.noovoweb.validator.Negative
import com.noovoweb.validator.Validated

@Validated
data class NegativeRequest(
    @Negative
    val value: Double?
)
