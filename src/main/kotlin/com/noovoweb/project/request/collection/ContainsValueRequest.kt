package com.noovoweb.project.request.collection

import com.noovoweb.validator.ContainsValue
import com.noovoweb.validator.Validated

@Validated
data class ContainsValueRequest(
    @ContainsValue("admin")
    val roles: List<String>?
)
