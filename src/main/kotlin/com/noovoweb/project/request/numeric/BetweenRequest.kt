package com.noovoweb.project.request.numeric

import com.noovoweb.validator.Between
import com.noovoweb.validator.Validated

@Validated
data class BetweenRequest(
    @Between(min = 0.0, max = 100.0)
    val value: Double?
)
