package com.noovoweb.project.request.structural

import com.noovoweb.validator.MinLength
import com.noovoweb.validator.Nullable
import com.noovoweb.validator.Validated

@Validated
data class NullableRequest(
    @Nullable
    @MinLength(2)
    val value: String?
)
