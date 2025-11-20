package com.noovoweb.project.request.conditional

import com.noovoweb.validator.RequiredIf
import com.noovoweb.validator.Validated

@Validated
data class RequiredIfRequest(
    val userType: String?,
    @RequiredIf(field = "userType", value = "premium")
    val licenseKey: String?
)
