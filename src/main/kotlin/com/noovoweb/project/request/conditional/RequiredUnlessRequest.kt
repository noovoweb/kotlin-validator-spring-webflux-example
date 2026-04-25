package com.noovoweb.project.request.conditional

import com.noovoweb.validator.RequiredUnless
import com.noovoweb.validator.Validated

@Validated
data class RequiredUnlessRequest(
    val hasCoupon: String?,
    @RequiredUnless(field = "hasCoupon", value = "true")
    val address: String?
)
