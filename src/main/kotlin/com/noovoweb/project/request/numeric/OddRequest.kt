package com.noovoweb.project.request.numeric

import com.noovoweb.validator.Odd
import com.noovoweb.validator.Validated

@Validated
data class OddRequest(
    @Odd
    val value: Int?
)
