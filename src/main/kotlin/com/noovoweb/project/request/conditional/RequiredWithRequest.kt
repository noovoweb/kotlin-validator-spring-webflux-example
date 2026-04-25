package com.noovoweb.project.request.conditional

import com.noovoweb.validator.RequiredWith
import com.noovoweb.validator.Validated

@Validated
data class RequiredWithRequest(
    val firstName: String?,
    val lastName: String?,
    @RequiredWith(fields = ["firstName", "lastName"])
    val middleName: String?
)
