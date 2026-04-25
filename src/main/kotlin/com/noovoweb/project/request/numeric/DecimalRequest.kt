package com.noovoweb.project.request.numeric

import com.noovoweb.validator.Decimal
import com.noovoweb.validator.Validated

@Validated
data class DecimalRequest(
    @Decimal
    val value: Double?
)
