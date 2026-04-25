package com.noovoweb.project.request.numeric

import com.noovoweb.validator.Integer
import com.noovoweb.validator.Validated

@Validated
data class IntegerRequest(
    @Integer
    val value: Double?
)
