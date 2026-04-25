package com.noovoweb.project.request.conditional

import com.noovoweb.validator.RequiredWithout
import com.noovoweb.validator.Validated

@Validated
data class RequiredWithoutRequest(
    val hasParent: String?,
    val hasGuardian: String?,
    @RequiredWithout(fields = ["hasParent", "hasGuardian"])
    val selfDeclaration: String?
)
