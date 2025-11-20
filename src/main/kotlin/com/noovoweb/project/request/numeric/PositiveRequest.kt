package com.noovoweb.project.request.numeric

import com.noovoweb.validator.Positive
import com.noovoweb.validator.Validated

@Validated
data class PositiveRequest(
    @Positive
    val value: Double?
)
