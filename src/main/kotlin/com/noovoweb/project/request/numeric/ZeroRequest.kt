package com.noovoweb.project.request.numeric

import com.noovoweb.validator.Zero
import com.noovoweb.validator.Validated

@Validated
data class ZeroRequest(
    @Zero
    val value: Double?
)
