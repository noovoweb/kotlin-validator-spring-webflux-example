package com.noovoweb.project.request.numeric

import com.noovoweb.validator.DivisibleBy
import com.noovoweb.validator.Validated

@Validated
data class DivisibleByRequest(
    @DivisibleBy(5)
    val value: Int?
)
